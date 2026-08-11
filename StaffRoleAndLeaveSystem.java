import java.util.*;

class Staff {
    int id;
    String name;
    String role;
    int totalLeaves;
    int usedLeaves;

    Staff(int id, String name, String role, int totalLeaves, int usedLeaves) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.totalLeaves = totalLeaves;
        this.usedLeaves = usedLeaves;
    }

    int remainingLeaves() {
        return totalLeaves - usedLeaves;
    }

    void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name);
        System.out.println("Today's Role: " + role);
        System.out.println("Leaves Used: " + usedLeaves + "/" + totalLeaves);
        System.out.println("Remaining Leaves: " + remainingLeaves());
        System.out.println("-----------------------------------");
    }
}

public class StaffRoleAndLeaveSystem {
    static List<Staff> staffList = new ArrayList<>();

    public static void addStaff(Scanner sc) {
        System.out.print("Enter Staff ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Role for Today: ");
        String role = sc.nextLine();
        System.out.print("Enter Total Leaves Allowed: ");
        int totalLeaves = sc.nextInt();
        System.out.print("Enter Leaves Already Used: ");
        int usedLeaves = sc.nextInt();

        staffList.add(new Staff(id, name, role, totalLeaves, usedLeaves));
        System.out.println("Staff record added successfully!");
    }

    public static void viewStaff(Scanner sc) {
        System.out.print("Enter Staff ID to view: ");
        int id = sc.nextInt();
        for (Staff s : staffList) {
            if (s.id == id) {
                s.displayInfo();
                return;
            }
        }
        System.out.println("Staff not found.");
    }

    public static void updateRole(Scanner sc) {
        System.out.print("Enter Staff ID to update role: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Staff s : staffList) {
            if (s.id == id) {
                System.out.print("Enter new role for today: ");
                s.role = sc.nextLine();
                System.out.println("Role updated successfully!");
                return;
            }
        }
        System.out.println("Staff not found.");
    }

    public static void updateLeaves(Scanner sc) {
        System.out.print("Enter Staff ID to update leaves: ");
        int id = sc.nextInt();
        for (Staff s : staffList) {
            if (s.id == id) {
                System.out.print("Enter new used leaves count: ");
                s.usedLeaves = sc.nextInt();
                System.out.println("Leaves updated successfully!");
                return;
            }
        }
        System.out.println("Staff not found.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Staff Role & Leave System ---");
            System.out.println("1. Add Staff Record");
            System.out.println("2. View Staff Info");
            System.out.println("3. Update Staff Role");
            System.out.println("4. Update Staff Leaves");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addStaff(sc); break;
                case 2: viewStaff(sc); break;
                case 3: updateRole(sc); break;
                case 4: updateLeaves(sc); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 5);
        sc.close();
    }
}
