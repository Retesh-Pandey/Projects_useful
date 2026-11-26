import java.util.Scanner;

public class MaskWearableSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Mask & Wearable Recommendation System ===");

        System.out.print("Enter Weather (Hot/Cold/Rainy): ");
        String weather = sc.nextLine();

        System.out.print("Enter Pollution Level (Low/Medium/High): ");
        String pollution = sc.nextLine();

        System.out.print("Enter Activity (Walking/Running/Cycling): ");
        String activity = sc.nextLine();

        System.out.println("\n--- Recommendations ---");

        // Mask Recommendation
        if (pollution.equalsIgnoreCase("High")) {
            System.out.println("Mask: N95 Mask");
        } else if (pollution.equalsIgnoreCase("Medium")) {
            System.out.println("Mask: Surgical Mask");
        } else {
            System.out.println("Mask: Cotton Mask");
        }

        // Wearable Recommendation
        if (weather.equalsIgnoreCase("Cold")) {
            System.out.println("Wearable: Smart Heated Jacket");
        } else if (weather.equalsIgnoreCase("Rainy")) {
            System.out.println("Wearable: Waterproof Smart Watch");
        } else {
            System.out.println("Wearable: Fitness Band");
        }

        // Activity Based Suggestion
        if (activity.equalsIgnoreCase("Running")) {
            System.out.println("Extra: Heart Rate Monitor");
        } else if (activity.equalsIgnoreCase("Cycling")) {
            System.out.println("Extra: Smart Helmet");
        } else {
            System.out.println("Extra: Step Counter");
        }

        System.out.println("\nStay Safe and Healthy!");
        sc.close();
    }
}