import java.util.Scanner;

public class ExamFormManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== EXAM FORM MANAGEMENT SYSTEM =====");

        // Student Details
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course Name: ");
        String course = sc.nextLine();

        System.out.print("Enter Semester: ");
        int semester = sc.nextInt();
        sc.nextLine();

        // Exam Details
        System.out.print("Enter Exam Type (Regular/Supplementary): ");
        String examType = sc.nextLine();

        System.out.print("Enter Subject 1: ");
        String subject1 = sc.nextLine();

        System.out.print("Enter Subject 2: ");
        String subject2 = sc.nextLine();

        System.out.print("Enter Subject 3: ");
        String subject3 = sc.nextLine();

        // Display Form
        System.out.println("\n===== EXAM FORM SUBMITTED =====");
        System.out.println("Student Name : " + name);
        System.out.println("Roll Number  : " + rollNo);
        System.out.println("Course       : " + course);
        System.out.println("Semester     : " + semester);
        System.out.println("Exam Type    : " + examType);
        System.out.println("Subjects Selected:");
        System.out.println("1. " + subject1);
        System.out.println("2. " + subject2);
        System.out.println("3. " + subject3);

        System.out.println("\nExam Form Submitted Successfully!");

        sc.close();
    }
}