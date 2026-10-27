import java.util.Scanner;

class FireAlertSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Firefighter Emergency Assistant ===");

        System.out.print("Enter Temperature (°C): ");
        double temperature = sc.nextDouble();

        System.out.print("Enter Smoke Level (0-100): ");
        int smokeLevel = sc.nextInt();

        System.out.print("Any people trapped? (yes/no): ");
        String trapped = sc.next();

        String severity;

        if (temperature > 200 || smokeLevel > 80) {
            severity = "HIGH";
        } else if (temperature > 100 || smokeLevel > 40) {
            severity = "MEDIUM";
        } else {
            severity = "LOW";
        }

        System.out.println("\n--- FIRE REPORT ---");
        System.out.println("Fire Severity: " + severity);

        if (severity.equals("HIGH")) {
            System.out.println("Action: Deploy all firefighting units.");
            System.out.println("Use protective breathing equipment.");
        } else if (severity.equals("MEDIUM")) {
            System.out.println("Action: Send response team immediately.");
            System.out.println("Monitor nearby areas.");
        } else {
            System.out.println("Action: Small fire detected.");
            System.out.println("Use extinguisher and monitor situation.");
        }

        if (trapped.equalsIgnoreCase("yes")) {
            System.out.println("PRIORITY: Rescue trapped civilians first!");
        }

        System.out.println("Emergency report generated successfully.");

        sc.close();
    }
}