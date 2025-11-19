public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.teach();
        teacher.teach(new Student("Lisa", "Simpson"));
        teacher.doPaperwork();

        Teacher primaryTeacher = new Teacher(new Student("Ralph", "Wiggum"));
        primaryTeacher.doPaperwork();
    }
}