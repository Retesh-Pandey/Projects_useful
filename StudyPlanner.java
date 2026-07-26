import java.util.*;

class StudyPlanner {
    static Scanner sc = new Scanner(System.in);

    // Subject class to hold topics
    static class Subject {
        String name;
        List<String> topics = new ArrayList<>();
        Set<String> completed = new HashSet<>();

        Subject(String name) {
            this.name = name;
        }

        void addTopic(String topic) {
            topics.add(topic);
        }

        void markCompleted(String topic) {
            if (topics.contains(topic)) {
                completed.add(topic);
                System.out.println("✅ Topic marked as completed!");
            } else {
                System.out.println("❌ Topic not found.");
            }
        }

        void showProgress() {
            int total = topics.size();
            int done = completed.size();
            System.out.println("Progress for " + name + ": " + done + "/" + total + " topics completed.");
        }
    }

    public static void main(String[] args) {
        Map<String, Subject> subjects = new HashMap<>();
        boolean running = true;

        while (running) {
            System.out.println("\n📚 Smart Study Planner");
            System.out.println("1. Add Subject");
            System.out.println("2. Add Topic to Subject");
            System.out.println("3. Mark Topic Completed");
            System.out.println("4. Show Progress");
            System.out.println("5. Show All Subjects & Topics");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter subject name: ");
                    String subName = sc.nextLine();
                    subjects.put(subName, new Subject(subName));
                    System.out.println("✅ Subject added!");
                    break;

                case 2:
                    System.out.print("Enter subject name: ");
                    subName = sc.nextLine();
                    if (subjects.containsKey(subName)) {
                        System.out.print("Enter topic: ");
                        String topic = sc.nextLine();
                        subjects.get(subName).addTopic(topic);
                        System.out.println("✅ Topic added!");
                    } else {
                        System.out.println("❌ Subject not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter subject name: ");
                    subName = sc.nextLine();
                    if (subjects.containsKey(subName)) {
                        System.out.print("Enter topic to mark completed: ");
                        String topic = sc.nextLine();
                        subjects.get(subName).markCompleted(topic);
                    } else {
                        System.out.println("❌ Subject not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter subject name: ");
                    subName = sc.nextLine();
                    if (subjects.containsKey(subName)) {
                        subjects.get(subName).showProgress();
                    } else {
                        System.out.println("❌ Subject not found.");
                    }
                    break;

                case 5:
                    for (Subject s : subjects.values()) {
                        System.out.println("\n📖 " + s.name);
                        for (String t : s.topics) {
                            String status = s.completed.contains(t) ? "✔️" : "❌";
                            System.out.println("   - " + t + " " + status);
                        }
                    }
                    break;

                case 6:
                    running = false;
                    System.out.println("👋 Exiting Study Planner. Stay productive!");
                    break;

                default:
                    System.out.println("❌ Invalid choice.");
            }
        }
    }
}
