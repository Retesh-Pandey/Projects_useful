import java.util.*;

public class TeenHelperApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> habits = new HashMap<>();
        habits.put("Study", 0);
        habits.put("Exercise", 0);
        habits.put("Reading", 0);
        habits.put("Sleep (8+ hrs)", 0);

        System.out.println("=== Teen Daily Mood & Habit Tracker ===");
        System.out.print("Enter your mood today (Happy, Sad, Stressed, Excited): ");
        String mood = sc.nextLine();

        System.out.println("\nTrack your habits (type 'yes' if done):");
        for (String habit : habits.keySet()) {
            System.out.print(habit + ": ");
            String input = sc.nextLine().toLowerCase();
            if (input.equals("yes")) {
                habits.put(habit, habits.get(habit) + 1);
            }
        }

        System.out.println("\n--- Summary ---");
        System.out.println("Mood today: " + mood);
        System.out.println("Habits completed:");
        for (Map.Entry<String, Integer> entry : habits.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue() + " times this week");
        }

        // Simple feedback
        if (mood.equalsIgnoreCase("Stressed") || mood.equalsIgnoreCase("Sad")) {
            System.out.println("\nTip: Try deep breathing or a short walk to relax.");
        } else if (mood.equalsIgnoreCase("Happy") || mood.equalsIgnoreCase("Excited")) {
            System.out.println("\nAwesome! Keep up the positive energy!");
        }

        System.out.println("\nKeep tracking daily to build healthy habits!");
        sc.close();
    }
}
