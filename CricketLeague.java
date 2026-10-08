import java.util.*;

class Team {
    String name;
    int matchesWon;

    Team(String name) {
        this.name = name;
        this.matchesWon = 0;
    }

    void addWin() {
        matchesWon++;
    }
}

public class CricketLeague {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Team> teams = new ArrayList<>();

        System.out.println("🏏 Welcome to Cricket League Manager!");
        System.out.print("Enter number of teams: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Register teams
        for (int i = 0; i < n; i++) {
            System.out.print("Enter team name: ");
            String name = sc.nextLine();
            teams.add(new Team(name));
        }

        // Record match results
        while (true) {
            System.out.println("\n1. Record Match Result\n2. Show Standings\n3. Declare Winner\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter winning team name: ");
                String winner = sc.nextLine();
                boolean found = false;
                for (Team t : teams) {
                    if (t.name.equalsIgnoreCase(winner)) {
                        t.addWin();
                        System.out.println("✅ Match recorded! " + t.name + " wins.");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("❌ Team not found.");
                }
            } else if (choice == 2) {
                System.out.println("\n📊 Current Standings:");
                for (Team t : teams) {
                    System.out.println(t.name + " - Matches Won: " + t.matchesWon);
                }
            } else if (choice == 3) {
                Team winnerTeam = null;
                for (Team t : teams) {
                    if (winnerTeam == null || t.matchesWon > winnerTeam.matchesWon) {
                        winnerTeam = t;
                    }
                }
                if (winnerTeam != null) {
                    System.out.println("\n🏆 League Winner: " + winnerTeam.name + " with " + winnerTeam.matchesWon + " wins!");
                } else {
                    System.out.println("No matches recorded yet.");
                }
            } else if (choice == 4) {
                System.out.println("👋 Exiting... Thank you!");
                break;
            } else {
                System.out.println("Invalid choice, try again.");
            }
        }
        sc.close();
    }
}
