public class Student {

    public String firstName;
    public String lastName;

    Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void info() {
        System.out.println(this.firstName + " " + this.lastName);
    }
}
