import java.util.*;

public class LawMemoryAid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Store sections and laws in a map
        Map<String, String> lawSections = new HashMap<>();
        lawSections.put("IPC 302", "Punishment for murder");
        lawSections.put("IPC 420", "Cheating and dishonestly inducing delivery of property");
        lawSections.put("IPC 376", "Punishment for rape");
        lawSections.put("IPC 498A", "Cruelty by husband or relatives of husband");

        System.out.println("=== Law Memory Aid ===");
        System.out.println("1. Search by Section");
        System.out.println("2. Quiz Mode");
        System.out.print("Choose option: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        if (choice == 1) {
            System.out.print("Enter Section (e.g., IPC 302): ");
            String section = sc.nextLine();
            if (lawSections.containsKey(section)) {
                System.out.println(section + " → " + lawSections.get(section));
            } else {
                System.out.println("Section not found. Try again.");
            }
        } else if (choice == 2) {
            Random rand = new Random();
            List<String> keys = new ArrayList<>(lawSections.keySet());
            String randomSection = keys.get(rand.nextInt(keys.size()));

            System.out.println("What is the law for: " + randomSection + "?");
            String answer = sc.nextLine();

            System.out.println("Correct Answer: " + lawSections.get(randomSection));
            System.out.println("Your Answer: " + answer);
        } else {
            System.out.println("Invalid choice.");
        }

        sc.close();
    }
}
