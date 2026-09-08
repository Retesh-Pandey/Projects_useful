import java.util.*;

class Household {
    String name;
    int powerNeed; // in kWh
    boolean isCritical;

    Household(String name, int powerNeed, boolean isCritical) {
        this.name = name;
        this.powerNeed = powerNeed;
        this.isCritical = isCritical;
    }
}

public class VillageElectricityManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sample households
        List<Household> households = new ArrayList<>();
        households.add(new Household("Hospital", 50, true));
        households.add(new Household("School", 30, true));
        households.add(new Household("House A", 20, false));
        households.add(new Household("House B", 15, false));
        households.add(new Household("Water Pump", 40, true));

        System.out.print("Enter total electricity available (kWh): ");
        int availablePower = sc.nextInt();

        // Prioritize critical households first
        households.sort((h1, h2) -> Boolean.compare(h2.isCritical, h1.isCritical));

        System.out.println("\nElectricity Distribution Plan:");
        for (Household h : households) {
            if (availablePower >= h.powerNeed) {
                System.out.println(h.name + " supplied with " + h.powerNeed + " kWh");
                availablePower -= h.powerNeed;
            } else {
                System.out.println(h.name + " NOT supplied (insufficient power)");
            }
        }

        System.out.println("\nRemaining power: " + availablePower + " kWh");
        sc.close();
    }
}
