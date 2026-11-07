import java.util.Scanner;

class JavelinThrower {
    String name;
    double distance;

    JavelinThrower(String name, double distance) {
        this.name = name;
        this.distance = distance;
    }
}

public class JavelinCompetition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of throwers: ");
        int n = sc.nextInt();
        sc.nextLine();

        JavelinThrower[] throwers = new JavelinThrower[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter thrower name: ");
            String name = sc.nextLine();

            System.out.print("Enter throw distance (meters): ");
            double distance = sc.nextDouble();
            sc.nextLine();

            throwers[i] = new JavelinThrower(name, distance);
        }

        JavelinThrower winner = throwers[0];

        for (int i = 1; i < n; i++) {
            if (throwers[i].distance > winner.distance) {
                winner = throwers[i];
            }
        }

        System.out.println("\n--- Competition Results ---");
        for (JavelinThrower t : throwers) {
            System.out.println(t.name + " : " + t.distance + " meters");
        }

        System.out.println("\nWinner: " + winner.name);
        System.out.println("Best Throw: " + winner.distance + " meters");

        sc.close();
    }
}