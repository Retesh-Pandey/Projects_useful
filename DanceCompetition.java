import java.util.Scanner;

public class DanceCompetition {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Dancer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Creativity Score (0-10): ");
        double creativity = sc.nextDouble();

        System.out.print("Enter Technique Score (0-10): ");
        double technique = sc.nextDouble();

        System.out.print("Enter Energy Score (0-10): ");
        double energy = sc.nextDouble();

        double total = creativity + technique + energy;
        double average = total / 3;

        System.out.println("\n----- Dance Competition Result -----");
        System.out.println("Dancer: " + name);
        System.out.println("Total Score: " + total);
        System.out.println("Average Score: " + average);

        if (average >= 9) {
            System.out.println("Award: Gold Performer");
        } else if (average >= 7) {
            System.out.println("Award: Silver Performer");
        } else if (average >= 5) {
            System.out.println("Award: Bronze Performer");
        } else {
            System.out.println("Award: Participation Certificate");
        }

        sc.close();
    }
}