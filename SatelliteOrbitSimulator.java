import java.util.Scanner;

public class SatelliteOrbitSimulator {
    // Constants
    static final double EARTH_RADIUS = 6371.0; // km
    static final double EARTH_MASS = 5.972e24; // kg
    static final double G = 6.67430e-11; // gravitational constant

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🚀 Satellite Orbit Simulator 🚀");
        System.out.print("Enter altitude above Earth (km): ");
        double altitude = sc.nextDouble();

        System.out.print("Enter satellite velocity (km/s): ");
        double velocity = sc.nextDouble();

        // Convert to meters
        double r = (EARTH_RADIUS + altitude) * 1000; 
        double v = velocity * 1000;

        // Calculate orbital velocity
        double orbitalVelocity = Math.sqrt(G * EARTH_MASS / r);

        System.out.printf("Required orbital velocity: %.2f km/s%n", orbitalVelocity / 1000);

        if (Math.abs(v - orbitalVelocity) < 500) {
            System.out.println("✅ The satellite can stay in orbit!");
        } else if (v < orbitalVelocity) {
            System.out.println("⚠️ The satellite will fall back to Earth.");
        } else {
            System.out.println("⚠️ The satellite will escape Earth's gravity!");
        }

        sc.close();
    }
}
