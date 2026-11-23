import java.util.Scanner;

public class WaterFilterSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Water Filter Recommendation System ===");

        System.out.print("Enter Water TDS (ppm): ");
        int tds = sc.nextInt();

        System.out.print("Is water muddy? (yes/no): ");
        String muddy = sc.next();

        System.out.print("Is there a bad smell? (yes/no): ");
        String smell = sc.next();

        System.out.println("\n----- Analysis Result -----");

        if (tds > 300) {
            System.out.println("Recommended Filter: RO Water Filter");
        } else if (tds >= 100 && tds <= 300) {
            System.out.println("Recommended Filter: UV + UF Water Filter");
        } else {
            System.out.println("Recommended Filter: UV Water Filter");
        }

        if (muddy.equalsIgnoreCase("yes")) {
            System.out.println("Add a Sediment Filter to remove dirt particles.");
        }

        if (smell.equalsIgnoreCase("yes")) {
            System.out.println("Add an Activated Carbon Filter to remove odor.");
        }

        System.out.println("Water filtration recommendation completed.");

        sc.close();
    }
}