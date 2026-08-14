import java.util.*;

class SmartQuizApp {
    static Scanner sc = new Scanner(System.in);
    static Map<String, List<String[]>> questionBank = new HashMap<>();
    static Map<String, Integer> studentScores = new HashMap<>();

    public static void main(String[] args) {
        // Sample questions
        questionBank.put("Math", Arrays.asList(
            new String[]{"What is 5+3?", "8"},
            new String[]{"Square root of 16?", "4"}
        ));
        questionBank.put("Science", Arrays.asList(
            new String[]{"What planet is known as the Red Planet?", "Mars"},
            new String[]{"What gas do humans need to breathe?", "Oxygen"}
        ));

        System.out.println("Welcome to Smart Quiz App!");
        System.out.print("Enter your name: ");
        String student = sc.nextLine();

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Take Quiz");
            System.out.println("2. View Score");
            System.out.println("3. Teacher Mode (Add Question)");
            System.out.println("4. Exit");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1 -> takeQuiz(student);
                case 2 -> viewScore(student);
                case 3 -> teacherMode();
                case 4 -> { System.out.println("Goodbye!"); return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void takeQuiz(String student) {
        System.out.print("Enter subject (Math/Science): ");
        String subject = sc.nextLine();
        List<String[]> questions = questionBank.get(subject);

        if (questions == null) {
            System.out.println("No questions available for this subject.");
            return;
        }

        int score = 0;
        for (String[] q : questions) {
            System.out.println(q[0]);
            String ans = sc.nextLine();
            if (ans.equalsIgnoreCase(q[1])) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: " + q[1]);
            }
        }
        studentScores.put(student, studentScores.getOrDefault(student, 0) + score);
        System.out.println("You scored " + score + " points!");
    }

    static void viewScore(String student) {
        System.out.println(student + "'s total score: " +
            studentScores.getOrDefault(student, 0));
    }

    static void teacherMode() {
        System.out.print("Enter subject: ");
        String subject = sc.nextLine();
        System.out.print("Enter question: ");
        String question = sc.nextLine();
        System.out.print("Enter answer: ");
        String answer = sc.nextLine();

        questionBank.putIfAbsent(subject, new ArrayList<>());
        questionBank.get(subject).add(new String[]{question, answer});
        System.out.println("Question added successfully!");
    }
}
