import java.util.*;

class Cure {
    String cause;
    String medicine;
    String dosage;

    Cure(String cause, String medicine, String dosage) {
        this.cause = cause;
        this.medicine = medicine;
        this.dosage = dosage;
    }

    @Override
    public String toString() {
        return "Cause: " + cause + "\nMedicine: " + medicine + "\nDosage: " + dosage;
    }
}

public class CropHealthAssistant {
    private static Map<String, Cure> diseaseMap = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize knowledge base
        loadDiseases();

        System.out.println("🌱 Welcome to Crop Health Assistant 🌱");
        int choice;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Detect Disease");
            System.out.println("2. Show All Diseases in Database");
            System.out.println("3. Add New Disease");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> detectDisease();
                case 2 -> showAllDiseases();
                case 3 -> addDisease();
                case 4 -> System.out.println("👋 Exiting Crop Health Assistant. Stay healthy!");
                default -> System.out.println("❌ Invalid choice. Try again.");
            }
        } while (choice != 4);

        sc.close();
    }

    private static void loadDiseases() {
        diseaseMap.put("Powdery Mildew", new Cure("Fungus", "Sulphur Fungicide", "2g per liter of water"));
        diseaseMap.put("Leaf Blight", new Cure("Bacteria", "Copper Oxychloride", "3g per liter of water"));
        diseaseMap.put("Stem Rust", new Cure("Fungus", "Propiconazole", "1ml per liter of water"));
        diseaseMap.put("Root Rot", new Cure("Fungus", "Carbendazim", "1.5g per liter of water"));
    }

    private static void detectDisease() {
        System.out.print("📸 Enter detected crop disease name: ");
        String disease = sc.nextLine();

        if (diseaseMap.containsKey(disease)) {
            Cure cure = diseaseMap.get(disease);
            System.out.println("\n✅ Diagnosis Result:");
            System.out.println(cure);
        } else {
            System.out.println("❌ Disease not found in database. Please consult an expert.");
        }
    }

    private static void showAllDiseases() {
        System.out.println("\n📚 Disease Database:");
        for (Map.Entry<String, Cure> entry : diseaseMap.entrySet()) {
            System.out.println("Disease: " + entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("----------------------");
        }
    }

    private static void addDisease() {
        System.out.print("Enter new disease name: ");
        String name = sc.nextLine();
        System.out.print("Enter cause: ");
        String cause = sc.nextLine();
        System.out.print("Enter recommended medicine: ");
        String medicine = sc.nextLine();
        System.out.print("Enter dosage: ");
        String dosage = sc.nextLine();

        diseaseMap.put(name, new Cure(cause, medicine, dosage));
        System.out.println("✅ New disease added successfully!");
    }
}
