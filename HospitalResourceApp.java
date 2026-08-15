import java.util.*;

class Patient {
    String name;
    int age;
    int severity; // 1 = mild, 2 = moderate, 3 = critical
    String allocatedResource;

    Patient(String name, int age, int severity, String allocatedResource) {
        this.name = name;
        this.age = age;
        this.severity = severity;
        this.allocatedResource = allocatedResource;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age +
               ", Severity: " + severity +
               ", Resource: " + allocatedResource;
    }
}

public class HospitalResourceApp {
    static Scanner sc = new Scanner(System.in);
    static List<Patient> patients = new ArrayList<>();
    static int generalBeds = 5, icuBeds = 3, ventilators = 2;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Hospital Resource Management ---");
            System.out.println("1. Admit Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Discharge Patient");
            System.out.println("4. View Resources");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> admitPatient();
                case 2 -> viewPatients();
                case 3 -> dischargePatient();
                case 4 -> viewResources();
                case 5 -> { System.out.println("System closed."); return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void admitPatient() {
        System.out.print("Enter patient name: ");
        String name = sc.nextLine();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        System.out.print("Enter severity (1-Mild, 2-Moderate, 3-Critical): ");
        int severity = sc.nextInt();
        sc.nextLine();

        String resource = allocateResource(severity);
        if (resource == null) {
            System.out.println("No resources available for severity level " + severity);
            return;
        }

        patients.add(new Patient(name, age, severity, resource));
        System.out.println("Patient admitted with resource: " + resource);
    }

    static String allocateResource(int severity) {
        if (severity == 1 && generalBeds > 0) {
            generalBeds--; return "General Bed";
        } else if (severity == 2 && icuBeds > 0) {
            icuBeds--; return "ICU Bed";
        } else if (severity == 3 && ventilators > 0) {
            ventilators--; return "Ventilator";
        }
        return null;
    }

    static void dischargePatient() {
        System.out.print("Enter patient name to discharge: ");
        String name = sc.nextLine();
        Patient toRemove = null;
        for (Patient p : patients) {
            if (p.name.equalsIgnoreCase(name)) {
                toRemove = p;
                break;
            }
        }
        if (toRemove != null) {
            patients.remove(toRemove);
            releaseResource(toRemove.allocatedResource);
            System.out.println("Patient discharged and resource released.");
        } else {
            System.out.println("Patient not found.");
        }
    }

    static void releaseResource(String resource) {
        switch (resource) {
            case "General Bed" -> generalBeds++;
            case "ICU Bed" -> icuBeds++;
            case "Ventilator" -> ventilators++;
        }
    }

    static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients admitted.");
        } else {
            for (Patient p : patients) {
                System.out.println(p);
            }
        }
    }

    static void viewResources() {
        System.out.println("General Beds: " + generalBeds);
        System.out.println("ICU Beds: " + icuBeds);
        System.out.println("Ventilators: " + ventilators);
    }
}
