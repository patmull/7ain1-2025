public class Main {
    public static void main(String[] args) {
        boolean isHuman = true;
        boolean isAnimal = false;
        /*
        if (isHuman) {
            System.out.println("I am human.");
        } else if (isAnimal) {
            System.out.println("I am an animal.");
        }*/
        boolean teamOsuIsReady = true;
        boolean teamVsbIsReady = false;
        if ((teamOsuIsReady && teamVsbIsReady)) { // THEN
            System.out.println("Derby match can start!");
        } else {
            System.out.println("Before match program.");
        }

        if(isHuman || isAnimal) { // OR
            if (isHuman) {
                System.out.println("I am human.");
            } else if (isAnimal) {
                System.out.println("I am an animal.");
            }
            System.out.println("I am mortal.");
        }
        System.out.println("Some other code...");
    }
}