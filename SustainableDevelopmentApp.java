import java.util.Scanner;

public class SustainableDevelopmentApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🌱 Sustainable Development Tracker 🌱");
        System.out.println("Enter your daily activities to estimate carbon footprint.");

        System.out.print("Kilometers traveled by car today: ");
        double kmCar = sc.nextDouble();

        System.out.print("Kilometers traveled by bicycle/walking today: ");
        double kmBike = sc.nextDouble();

        System.out.print("Units of electricity used today (kWh): ");
        double electricity = sc.nextDouble();

        // Simple emission factors (not exact, just illustrative)
        double carEmission = kmCar * 0.12;        // kg CO2 per km
        double bikeEmission = kmBike * 0.0;       // zero emissions
        double electricityEmission = electricity * 0.8; // kg CO2 per kWh

        double totalEmission = carEmission + bikeEmission + electricityEmission;

        System.out.println("\nYour estimated carbon footprint today: " + totalEmission + " kg CO2");

        if (totalEmission < 5) {
            System.out.println("✅ Great job! You're living sustainably.");
        } else if (totalEmission < 15) {
            System.out.println("⚠️ Not bad, but you can improve. Try using more renewable energy.");
        } else {
            System.out.println("❌ High footprint! Consider reducing car use or saving electricity.");
        }

        sc.close();
    }
}
