import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Example:
        // Uživatel zadá:
        // Login:
        // Heslo:
        // Vypsat: Správně zadané.
        // nebo: Chybně zadané.
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("=====REGISTRACE======");

        String emailRegister = null;
        String passwordRegister = null;

        boolean registerSuccessfull = false;
        do {
            System.out.print("E-mail: ");
            emailRegister = scanner4.nextLine();
            System.out.print("Heslo: ");
            passwordRegister = scanner4.nextLine();

            if(passwordRegister.contains(" ")) {
                System.out.println("Heslo nesmí obsahovat mezery.");
            } else if (passwordRegister.length() < 8) {
                System.out.println("Heslo je příliš krátké.");
            } else if (!emailRegister.contains("@") || !emailRegister.contains(".")) {
                System.out.println("Email je ve špatném formátu.");
            } else {
                registerSuccessfull = true;
                System.out.println("Úspěšně zaregistrován.");
            }

        } while(!registerSuccessfull);

        System.out.println("========LOGIN=======");

        boolean loginSuccessfull = false;
        do {
            System.out.print("E-mail: ");
            String emailLogin = scanner4.nextLine();
            System.out.print("Heslo: ");
            String passwordLogin = scanner4.nextLine();

            if(passwordLogin.equals(passwordRegister) && emailLogin.equals(emailRegister)) {
                loginSuccessfull = true;
                System.out.println("Úspěšně přihlášen.");
            } else {
                System.out.println("Přihlašovací údaje neodpovídají žádnému záznamu.");
            }
        } while(!loginSuccessfull);

        /*
        Scanner scanner4 = new Scanner(System.in);
        boolean registerSuccessfull = false;

        System.out.println("=====REGISTRACE======");
        System.out.print("E-mail: ");
        String emailRegister = scanner4.nextLine();
        System.out.print("Heslo: ");
        String passwordRegister = scanner4.nextLine();

        while(!registerSuccessfull) {
            if(passwordRegister.contains(" ")) {
                System.out.println("Heslo nesmí obsahovat mezery.");
            } else if (passwordRegister.length() < 8) {
                System.out.println("Heslo je příliš krátké.");
            } else if (!emailRegister.contains("@") || !emailRegister.contains(".")) {
                System.out.println("Email je ve špatném formátu.");
            } else {
                registerSuccessfull = true;
                System.out.println("Úspěšně zaregistrován.");
            }

            if (!registerSuccessfull) {
                System.out.print("E-mail: ");
                emailRegister = scanner4.nextLine();
                System.out.print("Heslo: ");
                passwordRegister = scanner4.nextLine();
            }
        }

        System.out.println("========LOGIN=======");
        System.out.print("E-mail: ");
        String emailLogin = scanner4.nextLine();
        System.out.print("Heslo: ");
        String passwordLogin = scanner4.nextLine();
        boolean loginSuccessfull = false;

        while(!loginSuccessfull) {
            if(passwordLogin.equals(passwordRegister) && emailLogin.equals(emailRegister)) {
                loginSuccessfull = true;
                System.out.println("Úspěšně přihlášen.");
            } else {
                System.out.println("Přihlašovací údaje neodpovídají žádnému záznamu.");
            }

            if (!loginSuccessfull) {
                System.out.print("E-mail: ");
                emailLogin = scanner4.nextLine();
                System.out.print("Heslo: ");
                passwordLogin = scanner4.nextLine();
            }
        }

         */

        /*
        System.out.println("========LOGIN=======");
        if(login.equals(password)) {
            System.out.println("Uživatel přihlášen.");
        } else {
            System.out.println("Chybně zadáno");
        }

         */

        // Example:
        // 1. název knihy
        // 2. vypsat autora na základě názvu
        // 3. testovat knihy s číselnými názvy a nějaká, co obsahuje pouze číslo v názvu.

        Scanner scanner3 = new Scanner(System.in);
        // constructor is for settings things like birthdate or birth number
        // Person newBaby = new Person("25-01-2025", "252501/7652", "Novák");
        // doctors.takeCareOf(newBaby);
        // doctors.takeCareOf(mother);
        // mother.recoverFromGivingABirth();
        // String babyName = mother.getBabyName();
        // String babyName = "Jan";
        // newBaby.setFirstName(babyName);
        System.out.print("Zadejte název knihy: ");
        String inputBookName = scanner3.nextLine();

        // we cannot test
        // if(inputBookName = 1984) X
        // if(inputBookName == 1984) X
        // if(inputBookName == "1984")
        // if(inputBookName.equals("1984")) {

        System.out.println("1. znak názvu knihy: "
                + inputBookName.toCharArray()[0]
                // notice not only I can write just 1st letter
                // but also use some method on string
                // helpful tools like .contains("donuts") in textual social media content
        );

        if(inputBookName.contains("1984")) {
            System.out.println("George Orwell");
        } else if (inputBookName.equals("Farenheit 451")) {
            System.out.println("Ray Bradbury");
        } else {
            System.out.println("We do not have this book in the system.");
        }

        // Example:
        // 1. sudé nebo liché číslo (even or odd)
        // 2. zkontrolovat, zda není zadané číslo záporné
        String exampleStr = "example str";
        if (exampleStr.contains(" ")) {
            System.out.println("Heslo nesmí obsahovat mezeru");
        }

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

/*

Example in JavaScript (functions). In Java only static methods are closest to functions
function exampleFunction(exampleInput) { console.log(exampleInput * exampleInput) };
undefined
exampleFunction(4)
16
 */