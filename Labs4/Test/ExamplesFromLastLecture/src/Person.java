public class Person {
    // constructor
    String firstName;
    String lastName;
    String birthDate;
    String birthNumber;

    Person(String birthDate, String birthNumber, String lastName) {
        // Hf: S x S x S != S
        // |S x S x S| = |S|^3
        // Df: {}
        this.birthDate = birthDate;
        this.birthNumber = birthNumber;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
