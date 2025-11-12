import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
        // String userEmailInDatabase = "patrik.muller@osu.cz";
        // String userPasswordInDatabase = "12345678";
        do {

        } while();
        /*
        while(true) {
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
                break;
            }
        }*/
    }
}