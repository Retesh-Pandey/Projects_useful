import java.util.Timer;
import java.util.TimerTask;

public class SmartAutomationScheduler {

    public static void main(String[] args) {
        Timer timer = new Timer();

        // Example Task 1: Send Reminder
        TimerTask reminderTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("🔔 Reminder: Time to check your progress!");
            }
        };

        // Example Task 2: Auto Cleanup
        TimerTask cleanupTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("🧹 Cleanup: Removing temporary files...");
            }
        };

        // Schedule tasks
        // Reminder every 5 seconds
        timer.schedule(reminderTask, 0, 5000);

        // Cleanup every 10 seconds
        timer.schedule(cleanupTask, 0, 10000);

        System.out.println("✅ Smart Automation Scheduler started...");
    }
}
