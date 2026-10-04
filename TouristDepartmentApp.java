import java.util.*;

public class TouristDepartmentApp {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Tourist Department System ===");
        System.out.print("Enter your destination city: ");
        String city = sc.nextLine();

        System.out.print("Enter your budget (INR): ");
        double budget = sc.nextDouble();
        sc.nextLine(); // consume newline

        System.out.print("Enter your interest (history, nature, shopping, adventure): ");
        String interest = sc.nextLine().toLowerCase();

        System.out.println("\n--- Attractions in " + city + " ---");
        showAttractions(interest);

        System.out.print("\nDo you want to book a guided tour? (yes/no): ");
        String book = sc.nextLine();

        if (book.equalsIgnoreCase("yes")) {
            System.out.println("Tour booked successfully for " + city + "!");
        } else {
            System.out.println("You can explore on your own.");
        }

        suggestBudgetPlan(budget);
        System.out.println("\nThank you for using the Tourist Department System!");
    }

    static void showAttractions(String interest) {
        switch (interest) {
            case "history":
                System.out.println("• Heritage Museum\n• Ancient Fort");
                break;
            case "nature":
                System.out.println("• Botanical Garden\n• National Park");
                break;
            case "shopping":
                System.out.println("• City Mall\n• Local Market");
                break;
            case "adventure":
                System.out.println("• Trekking Trail\n• River Rafting");
                break;
            default:
                System.out.println("• General City Tour");
        }
    }

    static void suggestBudgetPlan(double budget) {
        System.out.println("\n--- Budget Suggestion ---");
        if (budget < 1000) {
            System.out.println("Focus on free attractions and local food.");
        } else if (budget < 5000) {
            System.out.println("Enjoy mid-range tours and shopping.");
        } else {
            System.out.println("Go for premium tours and luxury stays.");
        }
    }
}
