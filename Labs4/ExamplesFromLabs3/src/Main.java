import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Example 3 BASIC:

        // Uživatel zadá:
        // E-mail:
        // Heslo:
        // Vypsat: Správně zadané.
        // nebo: Chybně zadané.
        // Example 3 BONUS:
        // 1. Uživatel se "zaregistruje" pomocí e-mailu a hesla splňující požadavky.
        // 2. Zkontroluje se síla hesla (můžete vymyslet různá pravidla). Např. zda je dlouhé
        // 3. Zkontroluje se, zda je e-mail (zhruba) ve správném tvaru.
        // 4. Přihlášení (viz BASIC), ověří se ze zadanými údaji v registraci.


        System.out.println("======REGISTRACE=======");
        Scanner userInputScanner = new Scanner(System.in);
        System.out.println("E-mail: ");
        String userEmailInDatabase = userInputScanner.nextLine();
        System.out.println("Heslo: ");
        String userPasswordInDatabase = userInputScanner.nextLine();
        if (userPasswordInDatabase.length() < 8) {
            System.out.println("Heslo je příliš krátké.");
        } else if (userEmailInDatabase.contains(" ")
                || userPasswordInDatabase.contains(" ")) {
            System.out.println("E-mail a heslo nesmí obsahovat mezery.");
        } else if (!userEmailInDatabase.contains("@")
                || !userEmailInDatabase.contains(".")) {
            System.out.println("E-mail má špatný formát.");
        } else if (userPasswordInDatabase.equals("12345678")) {
            System.out.println("Toto heslo je příliš slabé.");
        } else {
            System.out.println("Uživatel úspěšně zaregistrován.");
        }
        //String userEmailInDatabase = "patrik.muller@osu.cz";
        //String userPasswordInDatabase = "12345678";
        System.out.println("======LOGIN=======");
        userInputScanner = new Scanner(System.in);
        System.out.println("E-mail: ");
        String userEmailEntered = userInputScanner.nextLine();
        System.out.println("Heslo: ");
        String userPasswordEntered = userInputScanner.nextLine();

        if (!userEmailEntered.equals(userEmailInDatabase)) {
            System.out.println("Špatně zadaný e-mail.");
        } else if (!userPasswordEntered.equals(userPasswordInDatabase)) {
            System.out.println("Špatně zadané heslo. Pokud jste zapomněli heslo," +
                    "požádejte si o obnovu hesla.");
        } else {
            System.out.println("Uživatel úspěšně přihlášen.");
        }




        // Doctor doctor = new Doctor();

        System.out.println("Role v systému: ");
        System.out.println(Doctor.DOCTOR_PROFESSION_LABEL_CZ);
        System.out.println("System role: ");
        System.out.println(Doctor.DOCTOR_PROFESSION_LABEL_EN);


        int ExampleVariable = 5; // CAN DO but not RECOMMENDED
        double exampleDecimal = 45.5;
        float ExampleDecimalSmaller = 455.2f;
        int cost = 60;
        int _cost = 5;
        double costExample = 4.5;
        // String ExampleVariable = "d";
        double pi = 3.14;
        double radius = 6353;
        double surfaceArea = pi * radius * radius;

        System.out.println(surfaceArea);


        Doctor doctor = new Doctor("522-bdb", "Julius", "Dlaha");

        Person person = new Person("25-05-2025",
                "252505/4532",
                "Novák",
                4);
        person.setFirstName("Jan");
        doctor.checkBreath();
        person.breath();
        doctor.breathCheckResult(true);
        // f(x) ... x = "argument funkce"
        person.printBabyCard();

        System.out.println("Birth weight: ");
        // person.birthWeight = 3412412; // NOTICE: zkuste změnit na public/private
        // System.out.println(person.birthWeight);
        System.out.println(person.getBirthWeight());





                // Example 2:

        // 1. název knihy
        // 2. vypsat autora na základě názvu
        // 3. testovat knihy s číselnými názvy a nějaká, co obsahuje pouze číslo v názvu.
        Scanner scanner = new Scanner(System.in);

        System.out.print("Zadejte název knihy: ");
        String bookName = scanner.nextLine();

        if(bookName.equals("1984")) {
            System.out.println("George Orwell");
        } else if (bookName.equals("Farenheit 451")) {
            System.out.println("Ray Bradbury");
        } else {
            System.out.println("Nemáme tuto kniho v databázi.");
        }

        // Example 1:
        // 1. sudé nebo liché číslo (even or odd)
        // 2. zkontrolovat, zda není zadané číslo záporné
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Enter number:");
        int inputNumber = Integer.parseInt(scanner2.nextLine());
        // int inputNumber = enteredNumberString);
        // System.out.println(inputNumber + 4); // check
        if(inputNumber < 0) {
            System.out.println("Musíte zadat kladné číslo.");
        } else {
            if(inputNumber % 2 == 0)
                System.out.println("Sudé.");
            else if(inputNumber % 2 == 1)
                System.out.println("Liché.");
            else
                System.out.println("Neočekávaný stav.");;
        }



    }
}