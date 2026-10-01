import java.util.*;

class Student {
    String name;
    int roomNumber;
    double feesPaid;

    Student(String name, int roomNumber, double feesPaid) {
        this.name = name;
        this.roomNumber = roomNumber;
        this.feesPaid = feesPaid;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Room: " + roomNumber + ", Fees Paid: ₹" + feesPaid;
    }
}

public class HostelManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        boolean running = true;

        System.out.println("🏠 Hostel Management System");

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student by Name");
            System.out.println("4. Update Fees");
            System.out.println("5. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter room number: ");
                    int room = sc.nextInt();
                    System.out.print("Enter fees paid: ");
                    double fees = sc.nextDouble();
                    students.add(new Student(name, room, fees));
                    System.out.println("✅ Student added successfully!");
                    break;

                case 2:
                    System.out.println("\n--- Student Records ---");
                    for (Student s : students) {
                        System.out.println(s);
                    }
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();
                    boolean found = false;
                    for (Student s : students) {
                        if (s.name.equalsIgnoreCase(searchName)) {
                            System.out.println("Found: " + s);
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("❌ Student not found.");
                    break;

                case 4:
                    System.out.print("Enter student name to update fees: ");
                    String feeName = sc.nextLine();
                    boolean updated = false;
                    for (Student s : students) {
                        if (s.name.equalsIgnoreCase(feeName)) {
                            System.out.print("Enter new fees paid: ");
                            s.feesPaid = sc.nextDouble();
                            System.out.println("💰 Fees updated successfully!");
                            updated = true;
                            break;
                        }
                    }
                    if (!updated) System.out.println("❌ Student not found.");
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
