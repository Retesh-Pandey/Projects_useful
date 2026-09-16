import java.util.*;

public class TaskAutomationBot {
    private static final String[] motivationalQuotes = {
        "Keep pushing forward 🚀",
        "Small steps lead to big success 🌟",
        "Stay focused, stay strong 💪",
        "Consistency beats intensity 🔑"
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> tasks = new ArrayList<>();

        System.out.println("=== AI Automation Bot ===");
        System.out.println("Enter your tasks (type 'done' to finish):");

        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("done")) break;
            tasks.add(input);
        }

        System.out.println("\nAutomated Reminders:");
        Random rand = new Random();
        for (String task : tasks) {
            String quote = motivationalQuotes[rand.nextInt(motivationalQuotes.length)];
            System.out.println("🔔 Reminder: " + task + " | " + quote);
        }

        System.out.println("\nAll tasks have been automated with motivational boosts!");
        sc.close();
    }
}
