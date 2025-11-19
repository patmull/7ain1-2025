class UserController {

    private User user = new User(); // only one user stored

    public boolean register(String email, String password) {
        // validation rules
        if (password.length() < 8) {
            System.out.println("Heslo je příliš krátké.");
            return false;
        }
        if (email.contains(" ") || password.contains(" ")) {
            System.out.println("E-mail a heslo nesmí obsahovat mezery.");
            return false;
        }
        if (!email.contains("@") || !email.contains(".")) {
            System.out.println("E-mail má špatný formát.");
            return false;
        }
        if (password.equals("12345678")) {
            System.out.println("Toto heslo je příliš slabé.");
            return false;
        }

        // save user
        user.setEmail(email);
        user.setPassword(password);
        System.out.println("Uživatel úspěšně zaregistrován.");
        return true;
    }

    public boolean login(String email, String password) {
        if (!email.equals(user.getEmail())) {
            System.out.println("Špatně zadaný e-mail.");
            return false;
        }
        if (!password.equals(user.getPassword())) {
            System.out.println("Špatně zadané heslo. Pokud jste zapomněli heslo, požádejte si o obnovu hesla.");
            return false;
        }

        System.out.println("Uživatel úspěšně přihlášen.");
        return true;
    }
}
