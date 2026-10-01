import java.util.Scanner;

public class VehicleEfficiencyAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter vehicle type (Bike/Car): ");
        String type = sc.nextLine();

        System.out.println("Enter fuel type (Petrol/Diesel/Electric): ");
        String fuel = sc.nextLine();

        System.out.println("Enter distance traveled (km): ");
        double distance = sc.nextDouble();

        System.out.println("Enter fuel consumed (liters or kWh): ");
        double fuelUsed = sc.nextDouble();

        System.out.println("Enter fuel/energy price per unit: ");
        double price = sc.nextDouble();

        double mileage = distance / fuelUsed;
        double costPerKm = price / mileage;
        double emissions = 0;

        if(fuel.equalsIgnoreCase("Petrol")) emissions = fuelUsed * 2.31;
        else if(fuel.equalsIgnoreCase("Diesel")) emissions = fuelUsed * 2.68;

        System.out.println("\n--- Efficiency Report ---");
        System.out.println("Vehicle: " + type);
        System.out.println("Fuel Type: " + fuel);
        System.out.println("Mileage: " + mileage + " km/unit");
        System.out.println("Cost per km: ₹" + costPerKm);
        if(emissions > 0) System.out.println("CO₂ Emissions: " + emissions + " kg");

        if(type.equalsIgnoreCase("Bike")) {
            if(mileage > 40) System.out.println("Efficiency Rating: Excellent");
            else if(mileage > 25) System.out.println("Efficiency Rating: Moderate");
            else System.out.println("Efficiency Rating: Poor");
        } else {
            if(mileage > 20) System.out.println("Efficiency Rating: Excellent");
            else if(mileage > 12) System.out.println("Efficiency Rating: Moderate");
            else System.out.println("Efficiency Rating: Poor");
        }

        sc.close();
    }
}
