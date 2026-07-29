import java.util.*;

class Submission {
    String teamName;
    boolean hasReadme, hasDemo, hasPitchDeck;
    boolean plagiarismFree;
    boolean submittedOnTime;

    Submission(String teamName, boolean hasReadme, boolean hasDemo, boolean hasPitchDeck,
               boolean plagiarismFree, boolean submittedOnTime) {
        this.teamName = teamName;
        this.hasReadme = hasReadme;
        this.hasDemo = hasDemo;
        this.hasPitchDeck = hasPitchDeck;
        this.plagiarismFree = plagiarismFree;
        this.submittedOnTime = submittedOnTime;
    }

    boolean isValid() {
        return hasReadme && hasDemo && hasPitchDeck && plagiarismFree && submittedOnTime;
    }
}

public class HackathonValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Submission> submissions = new ArrayList<>();

        System.out.print("Enter number of teams: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Team name: ");
            String name = sc.nextLine();

            System.out.print("Has README (true/false): ");
            boolean readme = sc.nextBoolean();
            System.out.print("Has Demo Video (true/false): ");
            boolean demo = sc.nextBoolean();
            System.out.print("Has Pitch Deck (true/false): ");
            boolean pitch = sc.nextBoolean();
            System.out.print("Plagiarism Free (true/false): ");
            boolean plagiarism = sc.nextBoolean();
            System.out.print("Submitted On Time (true/false): ");
            boolean onTime = sc.nextBoolean();
            sc.nextLine();

            submissions.add(new Submission(name, readme, demo, pitch, plagiarism, onTime));
        }

        System.out.println("\n--- Validation Results ---");
        for (Submission s : submissions) {
            String status = s.isValid() ? "QUALIFIED ✅" : "ELIMINATED ❌";
            System.out.printf("%s: %s\n", s.teamName, status);
        }
    }
}
