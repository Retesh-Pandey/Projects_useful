import java.util.Scanner;

public class TeaMarketing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Tea Marketing System ===");

        System.out.print("Enter Tea Brand Name: ");
        String teaBrand = sc.nextLine();

        System.out.print("Enter Target Audience: ");
        String audience = sc.nextLine();

        System.out.print("Enter Marketing Budget (₹): ");
        double budget = sc.nextDouble();

        System.out.print("Enter Expected Monthly Sales: ");
        int sales = sc.nextInt();

        System.out.println("\n=== Marketing Report ===");
        System.out.println("Tea Brand: " + teaBrand);
        System.out.println("Target Audience: " + audience);
        System.out.println("Marketing Budget: ₹" + budget);
        System.out.println("Expected Sales: " + sales + " units");

        if (budget >= 50000) {
            System.out.println("Recommended Strategy: TV Ads and Influencer Marketing");
        } else if (budget >= 20000) {
            System.out.println("Recommended Strategy: Social Media Campaign");
        } else {
            System.out.println("Recommended Strategy: Local Promotions and Flyers");
        }

        if (sales >= 1000) {
            System.out.println("Market Prediction: High Demand");
        } else {
            System.out.println("Market Prediction: Moderate Demand");
        }

        sc.close();
    }
}
