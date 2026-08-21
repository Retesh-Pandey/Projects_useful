import java.util.*;

class Task {
    String name;
    boolean completed;

    Task(String name) {
        this.name = name;
        this.completed = false;
    }

    void markCompleted() {
        completed = true;
    }

    @Override
    public String toString() {
        return name + " - " + (completed ? "✅ Done" : "❌ Pending");
    }
}

public class FactoryShiftManager {
    private static List<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Factory Shift Task Manager ===");
        boolean running = true;

        while (running) {
            System.out.println("\n1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task Completed");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> completeTask();
                case 4 -> {
                    running = false;
                    System.out.println("Exiting... Stay safe!");
                }
                default -> System.out.println("Invalid choice, try again.");
            }
        }
    }

    private static void addTask() {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();
        tasks.add(new Task(name));
        System.out.println("Task added successfully!");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks yet.");
        } else {
            System.out.println("Tasks for this shift:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static void completeTask() {
        viewTasks();
        if (!tasks.isEmpty()) {
            System.out.print("Enter task number to mark completed: ");
            int num = scanner.nextInt();
            if (num > 0 && num <= tasks.size()) {
                tasks.get(num - 1).markCompleted();
                System.out.println("Task marked as completed!");
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }
}
