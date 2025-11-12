import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Example 2 from Labs 6
        


        // Example 1 from Labs 6
        int maxDistance = 25000;
        int actualDistance = 0;

        while(actualDistance < maxDistance) {
            System.out.println(actualDistance + "m");
            if (actualDistance == 0) {
                System.out.println("START!");
            } else if (actualDistance == maxDistance) {
                System.out.println("END!");
            }
            actualDistance += 10;

            // the world records
            if (actualDistance == 100) {
                System.out.println("Usain Bolt");
                System.out.println("Florence Griffith-Joyner");
            } else if (actualDistance == 200) {
                System.out.println("Usain Bolt");
                System.out.println("Florence Griffith-Joyner");
            } else if (actualDistance == 400) {
                System.out.println("Wayde van Niekerk");
                System.out.println("Marita Koch");
            } else if (actualDistance == 800) {
                System.out.println("David Rudisha");
                System.out.println("Jarmila Kratochvílová");
            } else if (actualDistance == 5000 || actualDistance == 10000 || actualDistance == 20000 || actualDistance == 25000) {
                System.out.println("Emil Zátopek (old WR)");
            }
        }
        /*
        while() {

        }*/

        // Example 3 from Labs 4
        String emailFromDatabase = "jan@osu.cz";
        String passwordFromDatabase = "1234";

        Scanner scanner = new Scanner(System.in);
        boolean isLoginOk = false;

        do {
            System.out.println("Zadejte jméno:");
            String enteredEmail = scanner.nextLine();
            System.out.println("Zadejte heslo:");
            String enteredPassword = scanner.nextLine();

            if(enteredEmail.equals(emailFromDatabase) && enteredPassword.equals(passwordFromDatabase)) {
                // boolean isLoginOk = true; // WRONG!
                // proměnné mají "jepičí život" pokud jsou v blocích!
                isLoginOk = true;
            }

            if (isLoginOk) {
                System.out.println("Uživatel úspěšně přihlášen!");
            } else {
                System.out.println("Špatně zadané heslo nebo jméno!");
            }

        } while(!isLoginOk);
    }
}