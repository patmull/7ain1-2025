public class Teacher {

    Student student;

    Teacher() {
    }

    Teacher(Student student) {
        this.student = student;
    }

    public void teach() {
        System.out.println("Teaching student: ");
        Student student = new Student("Bart", "Simpson");
        student.info();
    }

    public void teach(Student student) {
        System.out.println("Teaching student: ");
        this.student = student;
        student.info();
    }

    public void doPaperwork() {
        System.out.println("Doing paperwork...");
        System.out.println("of student: ");
        student.info();
    }
}
