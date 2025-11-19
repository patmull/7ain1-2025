import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UserController controller = new UserController();
        Scanner sc = new Scanner(System.in);

        boolean registered = false;

        // ====== REGISTRATION LOOP ======
        do {
            System.out.println("====== REGISTRACE ======");
            System.out.print("E-mail: ");
            String email = sc.nextLine();

            System.out.print("Heslo: ");
            String password = sc.nextLine();

            registered = controller.register(email, password);

            if (!registered) {
                System.out.println("Registrace se nezdařila. Zkuste to znovu.\n");
            }
        } while (!registered);

        boolean loggedIn = false;

        // ====== LOGIN LOOP ======
        do {
            System.out.println("====== LOGIN ======");
            System.out.print("E-mail: ");
            String emailLogin = sc.nextLine();

            System.out.print("Heslo: ");
            String passwordLogin = sc.nextLine();

            loggedIn = controller.login(emailLogin, passwordLogin);

            if (!loggedIn) {
                System.out.println("Přihlášení se nezdařilo. Zkuste to znovu.\n");
            }
        } while (!loggedIn);

        System.out.println("Program končí. Jste přihlášeni.");
    }
}
