import java.util.Scanner;

public class HealthConsultationApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Welcome to Health Consultation System ===");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("Hello " + name + "! Please describe your main symptom:");
        System.out.println("Options: cough, fever, headache, stomach pain");
        String symptom = sc.nextLine().toLowerCase();

        String advice;
        switch (symptom) {
            case "cough":
                advice = "You may have a common cold. Drink warm fluids and rest. If it persists, consult a doctor.";
                break;
            case "fever":
                advice = "Take plenty of rest and fluids. If temperature is above 102°F or lasts more than 3 days, seek medical help.";
                break;
            case "headache":
                advice = "Try to relax, stay hydrated, and avoid screen time. If headaches are frequent, consult a physician.";
                break;
            case "stomach pain":
                advice = "Avoid spicy food and drink water. If pain is severe or continuous, visit a doctor.";
                break;
            default:
                advice = "Symptom not recognized. Please consult a healthcare professional.";
        }

        System.out.println("\n--- Health Advice ---");
        System.out.println(advice);

        System.out.println("\nThank you for using the Health Consultation System!");
        sc.close();
    }
}
