public class Main {
    public static void main(String[] args) {
        int startDistance = 0;
        int endDistance = 30000;
        int incrementDistance = 10;
        int actualDistance = startDistance;

        for(int distance = 0; distance <= endDistance; distance+=10) {
            System.out.println(distance + "m");
            if(distance == 100) {
                System.out.println("Usain Bolt");
                System.out.println("Florence Griffith-Joyner");
            } else if(distance == 200) {
                System.out.println("Usain Bolt");
                System.out.println("Florence Griffith-Joyner");
            } else if (distance == 400) {
                System.out.println("Wayde van Niekerk");
                System.out.println("Marita Koch");
            } else if (distance == 800) {
                System.out.println("David Radisha");
                System.out.println("Jarmila Kratochvílová");
            } else if (distance == 5000
                    || distance == 10000
                    || distance == 20000
                    || distance == 30000
            ) {
                System.out.println("Emil Zátopek (old WR)");
            }
        }

        while(actualDistance <= endDistance) {
            System.out.println(actualDistance + "m");
            if(actualDistance == 100) {
                System.out.println("Usain Bolt");
                System.out.println("Florence Griffith-Joyner");
            } else if(actualDistance == 200) {
                System.out.println("Usain Bolt");
                System.out.println("Florence Griffith-Joyner");
            } else if (actualDistance == 400) {
                System.out.println("Wayde van Niekerk");
                System.out.println("Marita Koch");
            } else if (actualDistance == 800) {
                System.out.println("David Radisha");
                System.out.println("Jarmila Kratochvílová");
            } else if (actualDistance == 5000
                    || actualDistance == 10000
                    || actualDistance == 20000
                    || actualDistance == 30000
            ) {
                System.out.println("Emil Zátopek (old WR)");
            }
            actualDistance += incrementDistance;
        }
    }
}