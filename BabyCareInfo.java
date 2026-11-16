import java.util.Scanner;

public class BabyCareInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Baby Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Baby Age (in months): ");
        int age = sc.nextInt();

        System.out.println("\nBaby Name: " + name);
        System.out.println("Age: " + age + " months");

        if (age <= 6) {
            System.out.println("Suggestion: Breast milk is recommended.");
        } else if (age <= 12) {
            System.out.println("Suggestion: Introduce soft and nutritious foods.");
        } else if (age <= 24) {
            System.out.println("Suggestion: Encourage walking and speaking activities.");
        } else {
            System.out.println("Suggestion: Support learning through play and interaction.");
        }

        sc.close();
    }
}