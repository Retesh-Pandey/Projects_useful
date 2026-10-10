import java.util.*;

class Machine {
    String name;
    int usageHours;
    int maintenanceThreshold;

    Machine(String name, int threshold) {
        this.name = name;
        this.maintenanceThreshold = threshold;
        this.usageHours = 0;
    }

    void addUsage(int hours) {
        usageHours += hours;
    }

    boolean needsMaintenance() {
        return usageHours >= maintenanceThreshold;
    }

    void performMaintenance() {
        usageHours = 0;
        System.out.println(name + " has been serviced.");
    }
}

public class MechanicalIndustryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Machine> machines = new ArrayList<>();

        machines.add(new Machine("Lathe Machine", 100));
        machines.add(new Machine("Drill Press", 80));
        machines.add(new Machine("CNC Machine", 120));

        while (true) {
            System.out.println("\n--- Mechanical Industry System ---");
            System.out.println("1. Add usage hours");
            System.out.println("2. Check maintenance status");
            System.out.println("3. Perform maintenance");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Select machine: ");
                for (int i = 0; i < machines.size(); i++) {
                    System.out.println((i+1) + ". " + machines.get(i).name);
                }
                int m = sc.nextInt() - 1;
                System.out.print("Enter usage hours: ");
                int hrs = sc.nextInt();
                machines.get(m).addUsage(hrs);
                System.out.println("Usage updated.");
            } else if (choice == 2) {
                for (Machine machine : machines) {
                    System.out.println(machine.name + " -> " +
                        (machine.needsMaintenance() ? "Needs Maintenance!" : "OK"));
                }
            } else if (choice == 3) {
                System.out.println("Select machine to service: ");
                for (int i = 0; i < machines.size(); i++) {
                    System.out.println((i+1) + ". " + machines.get(i).name);
                }
                int m = sc.nextInt() - 1;
                machines.get(m).performMaintenance();
            } else if (choice == 4) {
                System.out.println("Exiting system...");
                break;
            }
        }
        sc.close();
    }
}
