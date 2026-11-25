import java.util.Scanner;

public class AKTUSitePortal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("      AKTU Student Portal");
        System.out.println("================================");

        System.out.println("1. View Result");
        System.out.println("2. Download Admit Card");
        System.out.println("3. View Syllabus");
        System.out.println("4. Academic Calendar");
        System.out.println("5. Exit");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter Roll Number: ");
                String roll = sc.next();
                System.out.println("Result Details");
                System.out.println("Roll No: " + roll);
                System.out.println("CGPA: 8.4");
                System.out.println("Status: PASS");
                break;

            case 2:
                System.out.println("Admit Card Download Request Sent.");
                break;

            case 3:
                System.out.println("Available Syllabus:");
                System.out.println("1. B.Tech CSE");
                System.out.println("2. B.Tech IT");
                System.out.println("3. B.Tech ECE");
                break;

            case 4:
                System.out.println("Academic Calendar:");
                System.out.println("Semester Start : August");
                System.out.println("Mid Exams      : October");
                System.out.println("End Exams      : December");
                break;

            case 5:
                System.out.println("Thank You!");
                break;

            default:
                System.out.println("Invalid Choice!");
        }

        sc.close();
    }
}