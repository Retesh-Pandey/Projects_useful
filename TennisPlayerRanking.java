import java.util.Scanner;

class TennisPlayer {
    String playerName;
    int grandSlamWins;
    int atpWins;

    TennisPlayer(String playerName, int grandSlamWins, int atpWins) {
        this.playerName = playerName;
        this.grandSlamWins = grandSlamWins;
        this.atpWins = atpWins;
    }

    void displayRanking() {
        int rankingPoints = (grandSlamWins * 2000) + (atpWins * 500);

        System.out.println("\n--- Tennis Player Report ---");
        System.out.println("Player Name: " + playerName);
        System.out.println("Ranking Points: " + rankingPoints);
    }
}

public class TennisPlayerRanking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Player Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Grand Slam Wins: ");
        int slamWins = sc.nextInt();

        System.out.print("Enter ATP Wins: ");
        int atpWins = sc.nextInt();

        TennisPlayer player = new TennisPlayer(name, slamWins, atpWins);
        player.displayRanking();
    }
}