import java.util.Scanner;

public class ApplianceConsumption {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== AC, Cooler & Fridge Consumption Calculator ===");

        // AC
        System.out.print("Enter AC power rating (Watts): ");
        double acPower = sc.nextDouble();
        System.out.print("Enter AC usage (hours/day): ");
        double acHours = sc.nextDouble();

        // Cooler
        System.out.print("Enter Cooler power rating (Watts): ");
        double coolerPower = sc.nextDouble();
        System.out.print("Enter Cooler usage (hours/day): ");
        double coolerHours = sc.nextDouble();

        // Fridge
        System.out.print("Enter Fridge power rating (Watts): ");
        double fridgePower = sc.nextDouble();
        System.out.print("Enter Fridge usage (hours/day): ");
        double fridgeHours = sc.nextDouble();

        // Electricity rate
        System.out.print("Enter electricity rate (Rs per kWh): ");
        double rate = sc.nextDouble();

        double acUnits = (acPower * acHours) / 1000;
        double coolerUnits = (coolerPower * coolerHours) / 1000;
        double fridgeUnits = (fridgePower * fridgeHours) / 1000;

        double totalUnits = acUnits + coolerUnits + fridgeUnits;
        double totalCost = totalUnits * rate;

        System.out.println("\n----- Daily Consumption Report -----");
        System.out.printf("AC Consumption: %.2f kWh\n", acUnits);
        System.out.printf("Cooler Consumption: %.2f kWh\n", coolerUnits);
        System.out.printf("Fridge Consumption: %.2f kWh\n", fridgeUnits);
        System.out.printf("Total Consumption: %.2f kWh\n", totalUnits);
        System.out.printf("Total Cost: Rs %.2f\n", totalCost);

        sc.close();
    }
}