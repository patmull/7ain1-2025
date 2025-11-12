import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String exampleStr = "example str";
        if (exampleStr.contains(" ")) {
            System.out.println("Heslo nesmí obsahovat mezeru");
        }

        // Example:
        // 1. sudé nebo liché číslo (even or odd)
        // 2. zkontrolovat, zda není zadané číslo záporné
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Enter number:");
        int exampleNumber = Integer.parseInt(scanner2.nextLine());
        // int exampleNumber = enteredNumberString);
        // System.out.println(exampleNumber + 4); // check
        if(exampleNumber < 0) {
            System.out.println("Musíte zadat kladné číslo.");
        } else {
            if(exampleNumber % 2 == 0) {
                System.out.println("Sudé.");
            } else {
                System.out.println("Liché.");
            }
        }
        // Example:
        // 1. název knihy
        // 2. vypsat autora na základě názvu
        // 3. zadání knihy obsahující pouze číselný název

        // Example:
        // Uživatel zadá:
        // Login:
        // Heslo:
        // Vypsat: Správně zadané.
        // nebo: Chybně zadané.


        Scanner scanner = new Scanner(System.in);
        System.out.println("Input 1:");
        String example1 = scanner.nextLine(); // NOTICE: this is string!
        System.out.println("Input 2:");
        String example2 = scanner.nextLine(); // NOTICE: this is string!

        if (example1 == example2) {
            System.out.println("Equality with == TRUE");
        } else {
            System.out.println("Equality with == FALSE");
        }
        if (example1.equals(example2)) {
            System.out.println("Equality with .equals() TRUE");
        }

        // The only practical difference:
        // char exampleChar = 'c';
        String exampleStringValidNum = "3242";
        System.out.println(Integer.valueOf(exampleStringValidNum)); // https://www.ascii-code.com/
        System.out.println(Integer.parseInt(exampleStringValidNum)); // But this does not work.


        System.out.println(5 % 3);

        String theSecondCollegeInOstravaGoals;
        String osuGoals;

        System.out.print("OSU: ");
        osuGoals = scanner.nextLine(); // NOTICE: this is string!

        System.out.print("\n");
        System.out.print("VSB: ");
        theSecondCollegeInOstravaGoals = scanner.nextLine(); // NOTICE: this is string!
        System.out.println("Výsledek ostravského derby 2025:");
        System.out.println("OSU " + osuGoals + " : " + theSecondCollegeInOstravaGoals + " VSB");
        System.out.println("Total goals in the derby match:");
        System.out.println(osuGoals + theSecondCollegeInOstravaGoals);
        System.out.println(Integer.parseInt(osuGoals) + Integer.parseInt(theSecondCollegeInOstravaGoals));
        System.out.println(Integer.valueOf("5") + Integer.valueOf("2"));
        System.out.println(Integer.valueOf(osuGoals) + Integer.valueOf(theSecondCollegeInOstravaGoals));

        // BONUS for nerds: try this in JavaScript:
        // parseInt(parseFloat("0.00000000000000005"))
        // Java won't allow this (thankfully!)
        // System.out.println(Integer.parseInt("" + Float.parseFloat("0.00000000000000005")));;
        // closest we can do is:
        int exampleInt = (int) Double.parseDouble("0.00000000000000005");
        System.out.println(exampleInt);
        System.out.println(exampleInt);

        // DIFFERENCE: valueOf(String) returns a new Integer() object; parseInt(String) returns a primitive int
        // but practically not really different, it gets converted anyways...
        String exampleNumberInString = "0.4223423422422424234242";

        Double parsedNumPrimitive1 = Double.parseDouble(exampleNumberInString);
        System.out.println(parsedNumPrimitive1);
        double parsedNumPrimitive2 = Double.parseDouble(exampleNumberInString);
        System.out.println(parsedNumPrimitive2);

        Double parsedNumObject1 = Double.valueOf(exampleNumberInString);
        System.out.println(parsedNumObject1);
        double parsedNumObject2 = Double.valueOf(exampleNumberInString);
        System.out.println(parsedNumObject2);

        float parsedNumPrimitiveFloat = Float.valueOf(exampleNumberInString);
        System.out.println(parsedNumPrimitiveFloat);
        Float parsedNumFloatObject = Float.parseFloat(exampleNumberInString);
        System.out.println(parsedNumFloatObject);

        double parsedNumFloatObjectFromDoublePrimitive = Float.parseFloat(exampleNumberInString);
        System.out.println(parsedNumFloatObjectFromDoublePrimitive);
        double parsedNumFloatObjectFromDouble = Float.valueOf(exampleNumberInString);
        System.out.println(parsedNumFloatObjectFromDouble);
    }
}