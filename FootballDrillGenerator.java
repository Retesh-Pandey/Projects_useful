import java.util.*;

public class FootballDrillGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Categories of drills
        String[] passingDrills = {
            "Short passes in pairs",
            "Triangle passing with movement",
            "One-touch passing under pressure"
        };

        String[] shootingDrills = {
            "Free-kick practice",
            "Penalty shootout challenge",
            "Shooting after dribble"
        };

        String[] staminaDrills = {
            "Sprint intervals (30m x 10)",
            "Shuttle runs with ball",
            "Continuous dribbling around cones"
        };

        String[] teamworkDrills = {
            "Small-sided 3v3 match",
            "Pressing and defending as a unit",
            "Quick transition attack drill"
        };

        // Menu
        System.out.println("Choose drill type:");
        System.out.println("1. Passing");
        System.out.println("2. Shooting");
        System.out.println("3. Stamina");
        System.out.println("4. Teamwork");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        Random rand = new Random();
        String drill = "";

        switch (choice) {
            case 1:
                drill = passingDrills[rand.nextInt(passingDrills.length)];
                break;
            case 2:
                drill = shootingDrills[rand.nextInt(shootingDrills.length)];
                break;
            case 3:
                drill = staminaDrills[rand.nextInt(staminaDrills.length)];
                break;
            case 4:
                drill = teamworkDrills[rand.nextInt(teamworkDrills.length)];
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        System.out.println("\nToday's suggested drill: " + drill);
    }
}
