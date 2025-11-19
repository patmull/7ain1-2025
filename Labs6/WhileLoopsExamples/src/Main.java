public class Main {
    public static void main(String[] args) {
        int tulos = 0;

        int i = 0;
        while (i < 4) {
            tulos += 3;
            i++;
        }

        System.out.println(tulos);

        int rabbitCount = 1;
        while(true) {
            System.out.println("Jdu vám takhle po lese, najednou " + rabbitCount
                    + ". králík.");
            System.out.println("Jen se na mě podíval a hned se začal smát.");
            rabbitCount++; // <=> // rabbitCount = rabbitCount + 1;
            if(rabbitCount > 5) {
                break;
            }
        }

        System.out.println("Copak jsem tady jen pro srandu králíků?");
        System.out.println("....");
        System.out.println("Tím to všechno hasne, se*u na ně.");











        int startDistance = 0;
        int endDistance = 30000;
        int incrementDistance = 10;
        int actualDistance = startDistance;

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



        int start = 2;
        int end = 100;
        int increment = 2;
        int sum = start;
        System.out.println("Od: " + sum);
        while(sum < end) {
            sum = sum + increment;
            if (sum == end) {
                break;
            }
            System.out.println(sum);
            // <=>
            // sum += increment;

        }
        // System.out.println("Od: " + start);
        System.out.println("Do: " + sum);
    }
}