import java.util.*;

class Team {
    String name;
    double innovation, technical, presentation, impact;
    double finalScore;

    Team(String name, double innovation, double technical, double presentation, double impact) {
        this.name = name;
        this.innovation = innovation;
        this.technical = technical;
        this.presentation = presentation;
        this.impact = impact;
        calculateFinalScore();
    }

    void calculateFinalScore() {
        // Weighted scoring system
        finalScore = (innovation * 0.4) + (technical * 0.3) + (presentation * 0.2) + (impact * 0.1);
    }
}

public class JudgeAssistant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Team> teams = new ArrayList<>();

        System.out.print("Enter number of teams: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Team name: ");
            String name = sc.nextLine();

            System.out.print("Innovation score (0-100): ");
            double innovation = sc.nextDouble();
            System.out.print("Technical score (0-100): ");
            double technical = sc.nextDouble();
            System.out.print("Presentation score (0-100): ");
            double presentation = sc.nextDouble();
            System.out.print("Impact score (0-100): ");
            double impact = sc.nextDouble();
            sc.nextLine();

            teams.add(new Team(name, innovation, technical, presentation, impact));
        }

        // Sort teams by final score
        teams.sort((a, b) -> Double.compare(b.finalScore, a.finalScore));

        System.out.println("\n--- Leaderboard ---");
        for (Team t : teams) {
            String status = (t.finalScore < 50) ? "ELIMINATED ❌" : "QUALIFIED ✅";
            System.out.printf("%s: %.2f (%s)\n", t.name, t.finalScore, status);
        }
    }
}
