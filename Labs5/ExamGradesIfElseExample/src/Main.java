import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Zadejte počat bodů ze zkoušky: ");
        Scanner scanner = new Scanner(System.in);
        String pointsStr = scanner.nextLine();
        int points = Integer.parseInt(pointsStr);
        System.out.println(points);

        boolean success = true;

        if (points < 0) {
            System.out.println("Nemůžete zadat záporné číslo!");
            success = false;
        }

        if (points > 100) {
            System.out.println("Nemůžete obdržet více bodů než 100");
            success = false;
        }

        if (success == true) {
            if(points < 50) {
                System.out.println("F");
            } else if (points >= 51 && points <= 60) {
                System.out.println("E");
            } else if (points >= 61 && points <= 70) {
                System.out.println("D");
            } else if (points >= 71 && points <= 80) {
                System.out.println("C");
            } else if (points >= 81 && points <= 90) {
                System.out.println("B");
            } else {
                System.out.println("A");
            }
        }
    }
}