import java.util.Arrays;
import java.util.Scanner;
//import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int exampleInt = (int) Double.parseDouble("0.90000000005");
        System.out.println(exampleInt);

        String exampleNumberAsString = "3";
        System.out.println((Integer.valueOf(exampleNumberAsString)
                + Integer.valueOf("2")));
        double exampleDoubleFromString = Double.parseDouble("0.000000000005");
        System.out.println(exampleDoubleFromString);
        // System.out.println(Integer.parseInt(Double.parseDouble("0.000000000005")));

        String goalsOsu;
        String goalsSecondCollegeInOstrava;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Góly OSU: ");
        goalsOsu = scanner.nextLine();
        System.out.print("Góly VSB: ");
        goalsSecondCollegeInOstrava = scanner.nextLine();
        // goalsOsu = "12";

        System.out.println(goalsOsu + " : " + goalsSecondCollegeInOstrava);
        // Celkový počet gólů:
        System.out.println("Celkový počet gólů: " + (goalsOsu + goalsSecondCollegeInOstrava));

        int goalsOsuNumber = Integer.parseInt(goalsOsu);
        int goalVsbNumber = Integer.parseInt(goalsSecondCollegeInOstrava);

        System.out.println("Celkový počet gólů: "
                + (goalsOsuNumber + goalVsbNumber));

        // Příklad:
        // Góly OSU: 10
        // Góly VSB: 0
        // OSU 10 : 0 VSB

        /*
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of this class: ");
        String nameOfClass = scanner.nextLine();
        System.out.println("Name of this class is: " + nameOfClass);
         */




        System.out.println("Open up my eager eyes\nI am Mr. Brightside");
        //System.out.print("\n"); // System.out.println(); // NOTICE: \n is better for the code readability
        System.out.println(Arrays.toString(args));
        //String hello = "Hello";
        String hello = new String("Hi");
        String world = "world.cz";
        System.out.println(hello + world);
        System.out.println(hello + ", " + world + "!");

        int a = 40;
        int b = 5453;

        System.out.println(a + b);

        double c = 332.3;
        double d = 332.2;
        // float d = 333.2f;
        float e = (float) c;

        System.out.println("c= " + (c + d) + ", " + e);

        // this is introduction to boolean data type:
        boolean isStudent = true;
        d = 4353;
        /*
        int someWholeNumber = c;
        *
        */
        System.out.println(world.toCharArray()[2]);
        char exampleChar = '@';
        System.out.println("hello" + exampleChar + world);

        System.out.println(5 % 3);
    }
}