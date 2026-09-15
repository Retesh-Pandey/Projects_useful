import java.util.*;

class Student {
    String name;
    int problemSolving;
    int communication;
    int technicalKnowledge;

    Student(String name, int problemSolving, int communication, int technicalKnowledge) {
        this.name = name;
        this.problemSolving = problemSolving;
        this.communication = communication;
        this.technicalKnowledge = technicalKnowledge;
    }

    double calculatePerformance() {
        // Weighted average: problem-solving 40%, communication 20%, technical 40%
        return (problemSolving * 0.4) + (communication * 0.2) + (technicalKnowledge * 0.4);
    }

    String getRating() {
        double score = calculatePerformance();
        if (score >= 80) return "Excellent";
        else if (score >= 60) return "Good";
        else if (score >= 40) return "Average";
        else return "Needs Improvement";
    }
}

public class InterviewEvaluation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i+1));
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Problem-Solving (0-100): ");
            int ps = sc.nextInt();
            System.out.print("Communication (0-100): ");
            int comm = sc.nextInt();
            System.out.print("Technical Knowledge (0-100): ");
            int tech = sc.nextInt();
            sc.nextLine(); // consume newline

            students.add(new Student(name, ps, comm, tech));
        }

        System.out.println("\n--- Interview Performance Report ---");
        for (Student s : students) {
            System.out.println("Name: " + s.name);
            System.out.println("Overall Score: " + s.calculatePerformance());
            System.out.println("Rating: " + s.getRating());
            System.out.println("-----------------------------------");
        }

        sc.close();
    }
}
