public class Main {
    public static void main(String[] args) {

        double exampleSaving = 1000000000000.0;
        exampleSaving = exampleSaving + 0.000000000001;
        System.out.println(exampleSaving);



        System.out.println("int:");
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println("double:");
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);
        System.out.println("float:");
        System.out.println(Float.MIN_VALUE);
        System.out.println(Float.MAX_VALUE);
        System.out.println("char:");
        System.out.println("2 bytes");
        System.out.println("boolean:");
        System.out.println("1 bit");
        System.out.println("long:");
        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println("byte = 1 byte");
        System.out.println(Byte.MIN_VALUE);
        System.out.println(Byte.MAX_VALUE);
        System.out.println("short = 2 byte");
        System.out.println(Short.MIN_VALUE);
        System.out.println(Short.MAX_VALUE);
    }
}