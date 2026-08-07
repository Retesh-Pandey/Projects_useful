import java.util.Scanner;

public class RuralHealthAssistant {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== AI-Powered Rural Health Assistant ===");
        System.out.println("Enter your symptoms (comma separated): ");
        String input = sc.nextLine().toLowerCase();

        int severityScore = 0;

        // Basic symptom rules
        if (input.contains("fever")) severityScore += 2;
        if (input.contains("cough")) severityScore += 2;
        if (input.contains("cold")) severityScore += 1;
        if (input.contains("headache")) severityScore += 1;
        if (input.contains("chest pain")) severityScore += 4;
        if (input.contains("breathing difficulty")) severityScore += 5;
        if (input.contains("vomiting")) severityScore += 3;
        if (input.contains("diarrhea")) severityScore += 3;

        // Risk assessment
        System.out.println("\n--- Health Assessment ---");
        if (severityScore <= 2) {
            System.out.println("🟢 Low Risk: Rest, stay hydrated, and monitor symptoms.");
        } else if (severityScore <= 5) {
            System.out.println("🟡 Moderate Risk: Visit a local clinic if symptoms persist.");
        } else {
            System.out.println("🔴 High Risk: Seek urgent medical care immediately!");
        }

        // Medicine info (basic guidance)
        System.out.println("\n--- Common Medicine Info ---");
        System.out.println("Paracetamol: 500mg every 6-8 hours (max 4 doses/day).");
        System.out.println("ORS: Drink frequently to prevent dehydration.");
        System.out.println("Note: Always consult a doctor before taking medicines.");

        sc.close();
    }
}
