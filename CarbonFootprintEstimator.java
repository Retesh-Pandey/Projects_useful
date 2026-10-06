import java.util.*;

public class CarbonFootprintEstimator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter distance traveled by car (km): ");
        double carKm = sc.nextDouble();

        System.out.println("Enter electricity used (kWh): ");
        double electricity = sc.nextDouble();

        System.out.println("Enter number of plastic items used today: ");
        int plasticItems = sc.nextInt();

        System.out.println("Enter food type (1=Veg, 2=Non-Veg): ");
        int foodType = sc.nextInt();

        double footprint = (carKm * 0.21) + (electricity * 0.5) + (plasticItems * 0.1);
        footprint += (foodType == 2) ? 2.0 : 0.5; // Non-veg higher emissions

        System.out.println("\n--- Daily Carbon Footprint Report ---");
        System.out.println("Total emissions: " + footprint + " kg CO2");

        if (footprint > 10) {
            System.out.println("⚠ High footprint! Suggestions:");
            System.out.println("- Use public transport");
            System.out.println("- Reduce electricity usage");
            System.out.println("- Avoid single-use plastics");
        } else {
            System.out.println("✅ Good job! Your footprint is within safe limits.");
        }
    }
}
