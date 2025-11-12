public class Doctor {

    String id;
    String firstName;
    String lastName;

    public static final String DOCTOR_PROFESSION_LABEL_CZ = "lékař";
    public static final String DOCTOR_PROFESSION_LABEL_EN = "doctor";

    public Doctor(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void checkBreath() {
        System.out.println("Checking the breath...");
    }

    public void breathCheckResult(boolean isBreathOk) {
        if (isBreathOk) {
            System.out.println("Breath is in good condition.");
        } else {
            System.out.println(
                    "There are problems found in breath check. " +
                            "Appointment will be scheduled."
            );
        }
    }
}
