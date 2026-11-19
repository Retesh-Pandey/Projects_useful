import java.util.Scanner;

class BasketballPlayer {
    String name;
    int points;
    int assists;
    int rebounds;

    BasketballPlayer(String name, int points, int assists, int rebounds) {
        this.name = name;
        this.points = points;
        this.assists = assists;
        this.rebounds = rebounds;
    }

    double performanceScore() {
        return points + (assists * 1.5) + (rebounds * 1.2);
    }

    void display() {
        System.out.println("\nPlayer Name: " + name);
        System.out.println("Points: " + points);
        System.out.println("Assists: " + assists);
        System.out.println("Rebounds: " + rebounds);
        System.out.printf("Performance Score: %.2f\n", performanceScore());
    }
}

public class BasketballAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Player Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Points Scored: ");
        int points = sc.nextInt();

        System.out.print("Enter Assists: ");
        int assists = sc.nextInt();

        System.out.print("Enter Rebounds: ");
        int rebounds = sc.nextInt();

        BasketballPlayer player =
                new BasketballPlayer(name, points, assists, rebounds);

        player.display();

        if (player.performanceScore() >= 40) {
            System.out.println("Rating: Excellent Player");
        } else if (player.performanceScore() >= 25) {
            System.out.println("Rating: Good Player");
        } else {
            System.out.println("Rating: Needs Improvement");
        }

        sc.close();
    }
}