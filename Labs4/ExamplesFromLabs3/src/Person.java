public class Person {

    String birthDate;
    String birthNumber;
    String firstName;
    String lastName;
    public int birthWeight;

    public Person(String birthDate, String birthNumber, String lastName, int birthWeight) {
        this.birthDate = birthDate;
        this.birthNumber = birthNumber;
        this.lastName = lastName;
        this.birthWeight = birthWeight;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void breath() {
        System.out.println("Breathing...");
    }

    public int getBirthWeight() {
        return this.birthWeight;
    }

    public void printBabyCard() {
        System.out.println("Jméno a příjmení:");
        System.out.println(this.firstName + " " + lastName);
        System.out.println("Datum narození:");
        System.out.println(birthDate);
        System.out.println("Porodní váha:");
        System.out.println(getBirthWeight());
    }
}
