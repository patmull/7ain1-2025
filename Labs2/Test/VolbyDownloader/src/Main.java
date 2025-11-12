// VolbyHtmlDownloader.java
// Java 11+
// Compile: javac VolbyHtmlDownloader.java
// Run examples:
//  java VolbyHtmlDownloader
//  java VolbyHtmlDownloader ps2025 vysledky.xml report.html
//  java VolbyHtmlDownloader ps2025 vysledky.xml report.html PS_VYSLEDKY_ROW 5

import java.io.*;
import java.net.URI;
import java.net.http.*;
import java.nio.file.*;
import java.util.*;
import javax.xml.stream.*;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.Characters;
import javax.xml.namespace.QName;

public class Main {
    private static final HttpClient HTTP = HttpClient.newBuilder()
            .followRedirects(HttpClient.Redirect.NORMAL)
            .build();

    private static final String DEFAULT_ELECTION = "ps2025";
    private static final String DEFAULT_FILE = "vysledky.xml";
    private static final String DEFAULT_OUT = "volby_report.html";

    public static void main(String[] args) {
        String election = args.length > 0 ? args[0] : DEFAULT_ELECTION;
        String odataFile = args.length > 1 ? args[1] : DEFAULT_FILE;
        String outHtml = args.length > 2 ? args[2] : DEFAULT_OUT;
        String sampleElement = args.length > 3 ? args[3] : null;
        int sampleLimit = args.length > 4 ? Integer.parseInt(args[4]) : 3;

        String url = String.format("https://www.volby.cz/appdata/%s/odata/%s", election, odataFile);
        Path xmlPath = Paths.get("downloaded_" + odataFile);

        try {
            System.out.println("Downloading: " + url);
            downloadToFile(url, xmlPath);
            System.out.println("Saved XML to: " + xmlPath.toAbsolutePath());

            String preview = readPreview(xmlPath, 2000);
            Map<String, Integer> counts = new HashMap<>();
            List<String> samples = new ArrayList<>();

            scanXml(xmlPath, counts, sampleElement, sampleLimit, samples);
            writeHtmlReport(outHtml, url, preview, counts, sampleElement, samples);

            System.out.println("HTML report written to: " + Paths.get(outHtml).toAbsolutePath());
        } catch (Exception e) {
            System.err.println("Failed: " + e.getMessage());
            e.printStackTrace(System.err);
        }
    }

    private static void downloadToFile(String url, Path outPath) throws Exception {
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("User-Agent", "VolbyHtmlDownloader/1.0")
                .GET()
                .build();
        HttpResponse<InputStream> resp = HTTP.send(req, HttpResponse.BodyHandlers.ofInputStream());
        int status = resp.statusCode();
        if (status >= 200 && status < 300) {
            try (InputStream in = resp.body()) {
                Files.copy(in, outPath, StandardCopyOption.REPLACE_EXISTING);
            }
        } else {
            throw new IOException("HTTP status: " + status + " when requesting " + url);
        }
    }

    private static String readPreview(Path xmlPath, int maxChars) {
        try {
            byte[] all = Files.readAllBytes(xmlPath);
            int len = Math.min(maxChars, all.length);
            return new String(all, 0, len);
        } catch (IOException e) {
            return "(preview failed: " + e.getMessage() + ")";
        }
    }

    private static void scanXml(Path xmlPath,
                                Map<String,Integer> counts,
                                String sampleElement,
                                int sampleLimit,
                                List<String> samples) throws Exception {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        try (InputStream in = Files.newInputStream(xmlPath)) {
            XMLEventReader reader = factory.createXMLEventReader(in);
            while (reader.hasNext()) {
                XMLEvent ev = reader.nextEvent();
                if (ev.isStartElement()) {
                    String name = ev.asStartElement().getName().getLocalPart();
                    counts.merge(name, 1, Integer::sum);

                    if (sampleElement != null && name.equals(sampleElement) && samples.size() < sampleLimit) {
                        // Capture the whole element (start -> matching end) into a string
                        StringWriter sw = new StringWriter();
                        XMLOutputFactory outF = XMLOutputFactory.newFactory();
                        XMLEventWriter writer = outF.createXMLEventWriter(sw);
                        writer.add(ev); // add the start element
                        int depth = 1;
                        while (reader.hasNext() && depth > 0) {
                            XMLEvent e2 = reader.nextEvent();
                            if (e2.isStartElement()) depth++;
                            else if (e2.isEndElement()) depth--;
                            writer.add(e2);
                        }
                        writer.close();
                        samples.add(sw.toString());
                    }
                }
            }
            reader.close();
        }
    }

    private static void writeHtmlReport(String outHtml,
                                        String sourceUrl,
                                        String preview,
                                        Map<String,Integer> counts,
                                        String sampleElement,
                                        List<String> samples) throws IOException {
        List<Map.Entry<String,Integer>> sorted = new ArrayList<>(counts.entrySet());
        sorted.sort((a,b) -> Integer.compare(b.getValue(), a.getValue()));

        StringBuilder html = new StringBuilder();
        html.append("<!doctype html>\n<html lang=\"cs\">\n<head>\n<meta charset=\"utf-8\">\n");
        html.append("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">\n");
        html.append("<title>Volby report</title>\n");
        html.append("<style>\n")
                .append("body{font-family:system-ui,-apple-system,Segoe UI,Roboto,'Helvetica Neue',Arial;margin:20px;background:#f6f7fb}\n")
                .append(".card{background:white;border-radius:8px;box-shadow:0 6px 18px rgba(20,20,60,0.08);padding:18px;margin-bottom:18px}\n")
                .append("h1{margin:0 0 10px}\n")
                .append("table{width:100%;border-collapse:collapse}\n")
                .append("th,td{padding:8px 10px;text-align:left;border-bottom:1px solid #eef}\n")
                .append("th{background:#f0f4ff}\n")
                .append("pre{background:#0f1724;color:#dbeafe;padding:12px;border-radius:6px;overflow:auto}\n")
                .append(".muted{color:#666;font-size:0.95rem}\n")
                .append("</style>\n</head>\n<body>\n");

        html.append("<div class=\"card\"><h1>Czech election data — report</h1>\n")
                .append("<p class=\"muted\">Source: <a href=\"").append(escapeHtml(sourceUrl)).append("\">")
                .append(escapeHtml(sourceUrl)).append("</a></p></div>\n");

        html.append("<div class=\"card\"><h2>XML preview</h2>\n")
                .append("<pre>").append(escapeHtml(preview)).append("</pre></div>\n");

        html.append("<div class=\"card\"><h2>Element counts</h2>\n")
                .append("<table><thead><tr><th>Element name</th><th style=\"width:140px\">Count</th></tr></thead><tbody>\n");
        int shown = 0;
        for (Map.Entry<String,Integer> e : sorted) {
            html.append("<tr><td>").append(escapeHtml(e.getKey())).append("</td><td>")
                    .append(String.valueOf(e.getValue())).append("</td></tr>\n");
            if (++shown >= 200) break;
        }
        html.append("</tbody></table>\n</div>\n");

        if (sampleElement != null) {
            html.append("<div class=\"card\"><h2>Sample elements: ").append(escapeHtml(sampleElement))
                    .append("</h2>\n");
            if (samples.isEmpty()) {
                html.append("<p class=\"muted\">No occurrences of that element were captured.</p>\n");
            } else {
                for (int i = 0; i < samples.size(); i++) {
                    html.append("<h3>Sample #").append(i+1).append("</h3>\n")
                            .append("<pre>").append(escapeHtml(samples.get(i))).append("</pre>\n");
                }
            }
            html.append("</div>\n");
        }

        html.append("<div class=\"card\"><p class=\"muted\">Generated by VolbyHtmlDownloader</p></div>\n");
        html.append("</body>\n</html>");

        Files.writeString(Paths.get(outHtml), html.toString(), java.nio.charset.StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    private static String escapeHtml(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;")
                .replace("\"", "&quot;").replace("'", "&#39;");
    }
}
