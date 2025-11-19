import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        System.out.println("======REGISTRACE=======");
        boolean registrationConditionsMet = false;
        String userEmail;
        String userPassword;
        User user = new User();
        do {
            System.out.println("E-mail: ");
            userEmail = userInputScanner.nextLine();
            System.out.println("Heslo: ");
            userPassword = userInputScanner.nextLine();

            registrationConditionsMet = user.register(userEmail, userPassword);
        } while(!registrationConditionsMet);

        user.setEmail(userEmail);
        user.setPassword(userPassword);

        boolean isLoginOk = false;
        System.out.println("User comes back to login...");
        do {
            System.out.println("======LOGIN=======");
            userInputScanner =
                    new Scanner(System.in);
            System.out.println("E-mail: ");
            String userEmailEntered = userInputScanner.nextLine();
            System.out.println("Heslo: ");
            String userPasswordEntered
                    = userInputScanner.nextLine();
            /*
            isLoginOk = user.login(
                    userEmailEntered,
                    userPasswordEntered,
                    user);
             */
            isLoginOk = user.login(
                    userEmailEntered,
                    userPasswordEntered);
        } while(!isLoginOk);

    }
}