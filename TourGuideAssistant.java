import java.util.Scanner;

public class TourGuideAssistant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Welcome to the Tour Guide Assistant ===");

        // Take user input
        System.out.print("Enter your destination city: ");
        String city = sc.nextLine();

        System.out.print("Enter your budget (in INR): ");
        double budget = sc.nextDouble();
        sc.nextLine(); // consume newline

        System.out.print("Enter your interest (history, nature, shopping, adventure): ");
        String interest = sc.nextLine().toLowerCase();

        // Simple recommendation logic
        System.out.println("\n--- Suggested Plan for " + city + " ---");

        if (interest.contains("history")) {
            System.out.println("Visit the famous museum and heritage sites.");
        } else if (interest.contains("nature")) {
            System.out.println("Explore local parks, gardens, and scenic spots.");
        } else if (interest.contains("shopping")) {
            System.out.println("Check out the city’s popular markets and malls.");
        } else if (interest.contains("adventure")) {
            System.out.println("Try trekking, water sports, or adventure rides nearby.");
        } else {
            System.out.println("Explore general attractions and cultural spots.");
        }

        // Budget suggestion
        if (budget < 1000) {
            System.out.println("Since your budget is low, focus on free or low-cost attractions.");
        } else if (budget < 5000) {
            System.out.println("You can enjoy mid-range activities and local food.");
        } else {
            System.out.println("You can explore premium tours, luxury stays, and fine dining.");
        }

        System.out.println("\nEnjoy your trip to " + city + "!");
        sc.close();
    }
}
