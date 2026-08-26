import java.util.Scanner;

class CricketPracticeTracker {
    private int totalRuns = 0;
    private int totalBallsFaced = 0;
    private int totalWicketsTaken = 0;
    private int totalOversBowled = 0;

    public void logBatting(int runs, int balls) {
        totalRuns += runs;
        totalBallsFaced += balls;
        System.out.println("✅ Batting session logged!");
    }

    public void logBowling(int wickets, int overs) {
        totalWicketsTaken += wickets;
        totalOversBowled += overs;
        System.out.println("✅ Bowling session logged!");
    }

    public void showStats() {
        System.out.println("\n📊 Practice Summary:");
        System.out.println("Total Runs Scored: " + totalRuns);
        System.out.println("Total Balls Faced: " + totalBallsFaced);
        if (totalBallsFaced > 0) {
            double strikeRate = (totalRuns * 100.0) / totalBallsFaced;
            System.out.println("Strike Rate: " + String.format("%.2f", strikeRate));
        }
        System.out.println("Total Wickets Taken: " + totalWicketsTaken);
        System.out.println("Total Overs Bowled: " + totalOversBowled);
        if (totalOversBowled > 0) {
            double bowlingAverage = (double) totalWicketsTaken / totalOversBowled;
            System.out.println("Wickets per Over: " + String.format("%.2f", bowlingAverage));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CricketPracticeTracker tracker = new CricketPracticeTracker();

        while (true) {
            System.out.println("\n🏏 Cricket Practice Tracker");
            System.out.println("1. Log Batting");
            System.out.println("2. Log Bowling");
            System.out.println("3. Show Stats");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter runs scored: ");
                    int runs = sc.nextInt();
                    System.out.print("Enter balls faced: ");
                    int balls = sc.nextInt();
                    tracker.logBatting(runs, balls);
                    break;
                case 2:
                    System.out.print("Enter wickets taken: ");
                    int wickets = sc.nextInt();
                    System.out.print("Enter overs bowled: ");
                    int overs = sc.nextInt();
                    tracker.logBowling(wickets, overs);
                    break;
                case 3:
                    tracker.showStats();
                    break;
                case 4:
                    System.out.println("👋 Goodbye! Keep practicing hard!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
