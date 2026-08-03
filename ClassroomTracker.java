import java.util.*;

class Student {
    String name;
    int id;
    List<Integer> grades = new ArrayList<>();
    int attendance = 0;

    Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void addGrade(int grade) {
        grades.add(grade);
    }

    void markAttendance() {
        attendance++;
    }

    double getAverage() {
        if (grades.isEmpty()) return 0;
        int sum = 0;
        for (int g : grades) sum += g;
        return (double) sum / grades.size();
    }
}

public class ClassroomTracker {
    static Map<Integer, Student> students = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Classroom Tracker ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade");
            System.out.println("3. Mark Attendance");
            System.out.println("4. Show Report");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.next();
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    students.put(id, new Student(name, id));
                    System.out.println("Student added!");
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();
                    if (students.containsKey(id)) {
                        System.out.print("Enter grade: ");
                        int grade = sc.nextInt();
                        students.get(id).addGrade(grade);
                        System.out.println("Grade added!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();
                    if (students.containsKey(id)) {
                        students.get(id).markAttendance();
                        System.out.println("Attendance marked!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Student Reports ---");
                    for (Student s : students.values()) {
                        System.out.println("ID: " + s.id + ", Name: " + s.name +
                                           ", Avg: " + s.getAverage() +
                                           ", Attendance: " + s.attendance);
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
