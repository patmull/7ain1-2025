import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;
import java.util.function.Predicate;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * CzechElectionsResults
 *
 * - Scrapes volby.cz PS2025 open-data landing page for JSON / ZIP / XML links.
 * - Downloads the first matching file found (prefers JSON/ZIP).
 * - If ZIP, searches inside for likely party/result JSON files (filenames containing 'stran', 'party', 'vysled', 'celk').
 * - Parses JSON trees heuristically (looks for arrays of objects with keys like 'nazev','hlasy','procento','mandaty').
 * - Prints a simple table: Party | Votes | Percent | Seats.
 *
 * Requires Java 11+, Maven with pom.xml (jsoup + jackson-databind).
 */
public class Main {
    private static final String OPENDATA_URL = "https://www.volby.cz/opendata/ps2025/ps2025_opendata.htm";
    private static final HttpClient HTTP = HttpClient.newHttpClient();
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        System.out.println("Scraping opendata index: " + OPENDATA_URL);
        Document doc = Jsoup.connect(OPENDATA_URL).userAgent("cz-election-java/1.0").get();

        // gather candidate links
        List<String> links = new ArrayList<>();
        for (Element a : doc.select("a[href]")) {
            String href = a.attr("abs:href").trim();
            if (href.isEmpty()) continue;
            String lower = href.toLowerCase();
            if (lower.endsWith(".json") || lower.endsWith(".zip") || lower.endsWith(".xml")) {
                links.add(href);
            } else {
                // sometimes links include query strings; check contains
                if (lower.contains(".json") || lower.contains(".zip") || lower.contains(".xml")) {
                    links.add(href);
                }
            }
        }

        if (links.isEmpty()) {
            System.err.println("No JSON/XML/ZIP links found on the opendata page. Visit the results dashboard at https://www.volby.cz/app/ps2025/");
            return;
        }

        System.out.printf("Found %d candidate data links. Trying each until we extract party results...%n", links.size());

        List<Map<String,String>> extracted = new ArrayList<>();
        for (String url : links) {
            System.out.println("Trying: " + url);
            try {
                byte[] content = download(url);
                if (isZipUrl(url) || looksLikeZip(content)) {
                    System.out.println("Detected ZIP archive, inspecting entries...");
                    List<String> candidateNames = Arrays.asList("stran", "strany", "party", "vysled", "celk", "results");
                    List<Map<String,String>> fromZip = inspectZipForJsons(content, candidateNames::contains);
                    if (!fromZip.isEmpty()) {
                        extracted.addAll(fromZip);
                        break;
                    }
                } else if (looksLikeJson(content)) {
                    List<Map<String,String>> parties = extractPartiesFromJsonBytes(content);
                    if (!parties.isEmpty()) {
                        extracted.addAll(parties);
                        break;
                    }
                } else if (looksLikeXml(content)) {
                    // optional: XML parsing could be added; for brevity, skip or attempt simple text heuristics
                    System.out.println("Found XML content; the program currently prefers JSON registries. You can re-run to try XML parsing.");
                } else {
                    System.out.println("Unknown file type or empty content.");
                }
            } catch (Exception e) {
                System.err.println("Failed to process " + url + " : " + e.getMessage());
            }
        }

        if (extracted.isEmpty()) {
            System.err.println("Could not automatically extract party results from discovered files. Try visiting the official results dashboard: https://www.volby.cz/app/ps2025/");
            return;
        }

        // Deduplicate and print
        Map<String, Map<String,String>> unique = new LinkedHashMap<>();
        for (Map<String,String> row : extracted) {
            String name = Optional.ofNullable(row.get("name")).orElse(row.get("nazev"));
            if (name == null) continue;
            name = name.trim();
            if (!unique.containsKey(name)) unique.put(name, row);
        }

        printTable(new ArrayList<>(unique.values()));
    }

    private static byte[] download(String url) throws Exception {
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("User-Agent","cz-election-java/1.0")
                .GET()
                .build();
        HttpResponse<byte[]> resp = HTTP.send(req, HttpResponse.BodyHandlers.ofByteArray());
        if (resp.statusCode() >= 400) throw new IOException("HTTP " + resp.statusCode());
        return resp.body();
    }

    private static boolean isZipUrl(String url) {
        return url.toLowerCase().endsWith(".zip");
    }

    private static boolean looksLikeZip(byte[] b) {
        if (b == null || b.length < 4) return false;
        // PK\003\004
        return b[0] == 0x50 && b[1] == 0x4B;
    }

    private static boolean looksLikeJson(byte[] b) {
        if (b == null) return false;
        String s = tryDecode(b);
        if (s == null) return false;
        s = s.trim();
        return s.startsWith("{") || s.startsWith("[");
    }

    private static boolean looksLikeXml(byte[] b) {
        if (b == null) return false;
        String s = tryDecode(b);
        if (s == null) return false;
        return s.trim().startsWith("<");
    }

    private static String tryDecode(byte[] b) {
        try { return new String(b, Charset.forName("UTF-8")); }
        catch (Exception ignored) {}
        try { return new String(b, Charset.forName("Windows-1250")); }
        catch (Exception ignored) {}
        try { return new String(b, Charset.defaultCharset()); }
        catch (Exception ignored) {}
        return null;
    }

    private static List<Map<String,String>> inspectZipForJsons(byte[] zipBytes, Predicate<String> namePredicate) throws IOException {
        List<Map<String,String>> found = new ArrayList<>();
        try (ByteArrayInputStream bais = new ByteArrayInputStream(zipBytes);
             ZipInputStream zis = new ZipInputStream(bais)) {
            ZipEntry e;
            while ((e = zis.getNextEntry()) != null) {
                String name = e.getName().toLowerCase();
                // prefer candidate filenames
                boolean candidate = namePredicate.test(name);
                if (!candidate) {
                    // still consider if endsWith .json and not huge
                    if (!name.endsWith(".json")) {
                        zis.closeEntry();
                        continue;
                    }
                }
                ByteArrayOutputStream bout = new ByteArrayOutputStream();
                byte[] buf = new byte[8192];
                int r;
                while ((r = zis.read(buf)) != -1) bout.write(buf, 0, r);
                byte[] entryBytes = bout.toByteArray();
                if (looksLikeJson(entryBytes)) {
                    List<Map<String,String>> parties = extractPartiesFromJsonBytes(entryBytes);
                    if (!parties.isEmpty()) {
                        System.out.println("Extracted from ZIP entry: " + e.getName());
                        found.addAll(parties);
                        // stop after first sensible file
                        return found;
                    }
                }
                zis.closeEntry();
            }
        }
        return found;
    }

    private static List<Map<String,String>> extractPartiesFromJsonBytes(byte[] bytes) {
        List<Map<String,String>> out = new ArrayList<>();
        try {
            JsonNode root = MAPPER.readTree(bytes);
            // deep-scan for arrays that look like party lists
            findPartyArrays(root, out);
        } catch (Exception e) {
            // try Windows-1250 decoding
            try {
                String s = new String(bytes, Charset.forName("Windows-1250"));
                JsonNode root = MAPPER.readTree(s);
                findPartyArrays(root, out);
            } catch (Exception ex) {
                // give up quietly
            }
        }
        return out;
    }

    private static void findPartyArrays(JsonNode node, List<Map<String,String>> out) {
        if (node == null) return;
        if (node.isArray()) {
            // check if elements are objects with party-like keys
            if (node.size() > 0 && node.get(0).isObject()) {
                Set<String> keys = new HashSet<>();
                node.forEach(n -> n.fieldNames().forEachRemaining(fn -> keys.add(fn.toLowerCase())));
                if (looksLikePartyKeys(keys)) {
                    // collect rows
                    for (JsonNode item : node) {
                        Map<String,String> row = new HashMap<>();
                        // common name keys
                        for (String nk : Arrays.asList("nazev","name","strana","party")) {
                            if (item.has(nk)) { row.put("name", item.get(nk).asText()); break; }
                            if (item.has(nk.toUpperCase())) { row.put("name", item.get(nk.toUpperCase()).asText()); break; }
                        }
                        // votes
                        for (String vk : Arrays.asList("hlasy","votes","hlas","hlasů","hlasu")) {
                            if (item.has(vk)) { row.put("votes", item.get(vk).asText()); break; }
                            if (item.has(vk.toUpperCase())) { row.put("votes", item.get(vk.toUpperCase()).asText()); break; }
                        }
                        // percent
                        for (String pk : Arrays.asList("procento","percent","podil","pct")) {
                            if (item.has(pk)) { row.put("pct", item.get(pk).asText()); break; }
                            if (item.has(pk.toUpperCase())) { row.put("pct", item.get(pk.toUpperCase()).asText()); break; }
                        }
                        // seats
                        for (String sk : Arrays.asList("mandaty","seats","mandate","mandat")) {
                            if (item.has(sk)) { row.put("seats", item.get(sk).asText()); break; }
                            if (item.has(sk.toUpperCase())) { row.put("seats", item.get(sk.toUpperCase()).asText()); break; }
                        }
                        out.add(row);
                    }
                    return;
                }
            }
            // otherwise scan array elements
            for (JsonNode child : node) findPartyArrays(child, out);
        } else if (node.isObject()) {
            // scan children
            node.fields().forEachRemaining(f -> findPartyArrays(f.getValue(), out));
        }
    }

    private static boolean looksLikePartyKeys(Set<String> keys) {
        // if keys contain name-like and votes-like key -> likely party array
        boolean hasName = keys.stream().anyMatch(k ->
                k.contains("nazev") || k.contains("name") || k.contains("stran") || k.contains("party"));
        boolean hasVotes = keys.stream().anyMatch(k ->
                k.contains("hlasy") || k.contains("votes") || k.contains("hlas"));
        return hasName && hasVotes;
    }

    private static void printTable(List<Map<String,String>> rows) {
        // sort by votes if numeric
        rows.sort((a,b) -> {
            long va = parseLongSafe(a.get("votes"));
            long vb = parseLongSafe(b.get("votes"));
            return Long.compare(vb, va);
        });

        System.out.printf("%-40s | %-12s | %-8s | %-6s%n", "Party", "Votes", "Pct", "Seats");
        System.out.println("--------------------------------------------------------------------------------");
        for (Map<String,String> r : rows) {
            String name = Optional.ofNullable(r.get("name")).orElse("-");
            String votes = Optional.ofNullable(r.get("votes")).orElse("-");
            String pct = Optional.ofNullable(r.get("pct")).orElse("-");
            String seats = Optional.ofNullable(r.get("seats")).orElse("-");
            System.out.printf("%-40s | %-12s | %-8s | %-6s%n", truncate(name,40), votes, pct, seats);
        }
    }

    private static long parseLongSafe(String s) {
        if (s == null) return 0;
        String digits = s.replaceAll("[^0-9]", "");
        if (digits.isEmpty()) return 0;
        try { return Long.parseLong(digits); } catch (Exception e) { return 0; }
    }

    private static String truncate(String s, int n) {
        if (s == null) return "";
        return s.length() <= n ? s : s.substring(0,n-3) + "...";
    }
}
