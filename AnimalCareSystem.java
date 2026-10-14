import java.util.*;

class Animal {
    String name;
    String species;
    String symptoms;
    String suggestedTreatment;

    Animal(String name, String species, String symptoms) {
        this.name = name;
        this.species = species;
        this.symptoms = symptoms;
        this.suggestedTreatment = suggestTreatment(symptoms);
    }

    private String suggestTreatment(String symptoms) {
        if (symptoms.toLowerCase().contains("cough")) {
            return "Give warm shelter and veterinary checkup for respiratory infection.";
        } else if (symptoms.toLowerCase().contains("wound")) {
            return "Clean wound, apply antiseptic, and consult vet if severe.";
        } else if (symptoms.toLowerCase().contains("fever")) {
            return "Provide hydration, monitor temperature, and seek vet advice.";
        } else {
            return "Consult veterinarian for proper diagnosis.";
        }
    }

    public void displayInfo() {
        System.out.println("Animal: " + name);
        System.out.println("Species: " + species);
        System.out.println("Symptoms: " + symptoms);
        System.out.println("Suggested Treatment: " + suggestedTreatment);
        System.out.println("-----------------------------------");
    }
}

public class AnimalCareSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Animal> records = new ArrayList<>();

        while (true) {
            System.out.println("1. Add Animal Record");
            System.out.println("2. View Records");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter animal name: ");
                String name = sc.nextLine();
                System.out.print("Enter species: ");
                String species = sc.nextLine();
                System.out.print("Enter symptoms: ");
                String symptoms = sc.nextLine();

                Animal a = new Animal(name, species, symptoms);
                records.add(a);
                System.out.println("Record added successfully!\n");
            } else if (choice == 2) {
                for (Animal a : records) {
                    a.displayInfo();
                }
            } else {
                System.out.println("Exiting system...");
                break;
            }
        }
        sc.close();
    }
}
