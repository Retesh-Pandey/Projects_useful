import java.util.*;
import java.io.*;

class SmartPlanner {
    static Scanner sc = new Scanner(System.in);
    static Map<String, List<String>> subjects = new HashMap<>();
    static Set<String> completed = new HashSet<>();
    static final String FILE_NAME = "smartplanner.txt";

    public static void main(String[] args) {
        loadData();
        while (true) {
            System.out.println("\n--- Smart Study Planner ---");
            System.out.println("1. Add Subject & Topics");
            System.out.println("2. Mark Topic Completed");
            System.out.println("3. Show Progress");
            System.out.println("4. Daily Plan");
            System.out.println("5. Save & Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> addSubject();
                case 2 -> markCompleted();
                case 3 -> showProgress();
                case 4 -> dailyPlan();
                case 5 -> { saveData(); return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addSubject() {
        System.out.print("Enter subject name: ");
        String subject = sc.nextLine();
        System.out.print("Enter topics (comma separated): ");
        String[] topics = sc.nextLine().split(",");
        subjects.put(subject, new ArrayList<>(Arrays.asList(topics)));
    }

    static void markCompleted() {
        System.out.print("Enter topic name to mark completed: ");
        String topic = sc.nextLine();
        completed.add(topic.trim());
    }

    static void showProgress() {
        int total = subjects.values().stream().mapToInt(List::size).sum();
        int done = completed.size();
        System.out.println("Progress: " + done + "/" + total + " topics completed.");
    }

    static void dailyPlan() {
        System.out.println("Today's Plan:");
        subjects.forEach((sub, topics) -> {
            topics.stream().filter(t -> !completed.contains(t.trim()))
                  .limit(1).forEach(t -> System.out.println(sub + ": " + t));
        });
    }

    static void saveData() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            subjects.forEach((sub, topics) -> pw.println(sub + ":" + String.join(",", topics)));
            pw.println("COMPLETED:" + String.join(",", completed));
        } catch (IOException e) { e.printStackTrace(); }
    }

    static void loadData() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("COMPLETED:")) {
                    completed.addAll(Arrays.asList(line.replace("COMPLETED:", "").split(",")));
                } else {
                    String[] parts = line.split(":");
                    subjects.put(parts[0], new ArrayList<>(Arrays.asList(parts[1].split(","))));
                }
            }
        } catch (IOException ignored) {}
    }
}
