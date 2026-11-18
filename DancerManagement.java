import java.util.Scanner;

class Dancer {
    String name;
    String danceStyle;
    int age;
    double rating;

    Dancer(String name, String danceStyle, int age, double rating) {
        this.name = name;
        this.danceStyle = danceStyle;
        this.age = age;
        this.rating = rating;
    }

    void displayDetails() {
        System.out.println("\n--- Dancer Details ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Dance Style: " + danceStyle);
        System.out.println("Performance Rating: " + rating + "/10");

        if (rating >= 8) {
            System.out.println("Performance: Excellent");
        } else if (rating >= 5) {
            System.out.println("Performance: Good");
        } else {
            System.out.println("Performance: Needs Improvement");
        }
    }
}

public class DancerManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Dancer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Dance Style: ");
        String style = sc.nextLine();

        System.out.print("Enter Performance Rating (0-10): ");
        double rating = sc.nextDouble();

        Dancer dancer = new Dancer(name, style, age, rating);
        dancer.displayDetails();

        sc.close();
    }
}
