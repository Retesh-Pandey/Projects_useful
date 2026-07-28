import java.util.Scanner;

public class HotelBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Welcome to the Hotel Booking System ===");

        // User input
        System.out.print("Enter destination city: ");
        String city = sc.nextLine();

        System.out.print("Enter number of guests: ");
        int guests = sc.nextInt();

        System.out.print("Enter number of nights: ");
        int nights = sc.nextInt();

        System.out.print("Enter your budget per night (in INR): ");
        double budget = sc.nextDouble();

        // Simple hotel recommendation logic
        System.out.println("\n--- Hotel Options in " + city + " ---");

        if (budget < 1000) {
            System.out.println("• Budget Inn: Basic rooms, suitable for backpackers.");
        } else if (budget < 3000) {
            System.out.println("• Comfort Stay: Mid-range hotel with good amenities.");
        } else if (budget < 7000) {
            System.out.println("• Luxury Suites: Premium rooms with pool and spa.");
        } else {
            System.out.println("• Elite Resort: 5-star luxury experience.");
        }

        // Cost calculation
        double totalCost = budget * nights * guests;
        System.out.println("\nEstimated total cost for " + guests + " guest(s) and " 
                           + nights + " night(s): INR " + totalCost);

        System.out.println("Thank you for using the Hotel Booking System!");
        sc.close();
    }
}
