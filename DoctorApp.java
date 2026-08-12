import java.util.*;

class Patient {
    String name;
    int age;
    String disease;
    String prescription;

    Patient(String name, int age, String disease, String prescription) {
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.prescription = prescription;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age +
               ", Disease: " + disease +
               ", Prescription: " + prescription;
    }
}

public class DoctorApp {
    static Scanner sc = new Scanner(System.in);
    static List<Patient> patients = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Doctor Patient Management ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient by Name");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addPatient();
                case 2 -> viewPatients();
                case 3 -> searchPatient();
                case 4 -> {
                    System.out.println("Exiting system...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addPatient() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter disease: ");
        String disease = sc.nextLine();
        System.out.print("Enter prescription: ");
        String prescription = sc.nextLine();

        patients.add(new Patient(name, age, disease, prescription));
        System.out.println("Patient added successfully!");
    }

    static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            for (Patient p : patients) {
                System.out.println(p);
            }
        }
    }

    static void searchPatient() {
        System.out.print("Enter patient name to search: ");
        String name = sc.nextLine();
        boolean found = false;
        for (Patient p : patients) {
            if (p.name.equalsIgnoreCase(name)) {
                System.out.println("Patient found: " + p);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Patient not found.");
        }
    }
}
