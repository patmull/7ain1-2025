public class User {
    private String email;
    private String password;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean login(String userEmail,
                         String userPassword) {
        boolean isLoginOk = false;
        if (!userEmail.equals(this.getEmail())) {
            System.out.println("Špatně zadaný e-mail.");
        } else if (!userPassword
                .equals(this.getPassword())) {
            System.out.println("Špatně zadané heslo. " +
                    "Pokud jste zapomněli heslo," +
                    "požádejte si o obnovu hesla.");
        } else {
            isLoginOk = true;
            System.out.println("Uživatel úspěšně přihlášen.");
        }
        return isLoginOk;
    }

    public boolean login(String userEmail,
                         String userPassword,
                         User user) {
        boolean isLoginOk = false;
        if (!userEmail.equals(user.getEmail())) {
            System.out.println("Špatně zadaný e-mail.");
        } else if (!userPassword
                .equals(user.getPassword())) {
            System.out.println("Špatně zadané heslo. " +
                    "Pokud jste zapomněli heslo," +
                    "požádejte si o obnovu hesla.");
        } else {
            isLoginOk = true;
            System.out.println("Uživatel úspěšně přihlášen.");
        }
        return isLoginOk;
    }

    public boolean register(String userEmail, String userPassword) {
        boolean conditionsMet = false;
        if (userPassword.length() < 8) {
            System.out.println("Heslo je příliš krátké.");
        } else if (userEmail.contains(" ")
                || userPassword.contains(" ")) {
            System.out.println("E-mail a heslo nesmí obsahovat mezery.");
        } else if (!userEmail.contains("@")
                || !userEmail.contains(".")) {
            System.out.println("E-mail má špatný formát.");
        } else if (userPassword.equals("12345678")) {
            System.out.println("Toto heslo je příliš slabé.");
        } else {
            System.out.println("Uživatel úspěšně zaregistrován.");
            conditionsMet = true;
            // return true; // 2. varianta
        }

        // return false; // 2. varianta
        return conditionsMet;
    }
}
