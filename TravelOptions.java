public class TravelOptions {
    public static void main(String[] args) {
        String[] trains = {
            "Express Train — 8:00 AM",
            "Local Train — 9:30 AM"
        };

        String[] buses = {
            "City Bus — 8:30 AM",
            "Intercity Bus — 10:00 AM"
        };

        System.out.println("Train options:");
        for (String train : trains) {
            System.out.println("- " + train);
        }

        System.out.println("\nBus options:");
        for (String bus : buses) {
            System.out.println("- " + bus);
        }
    }
}