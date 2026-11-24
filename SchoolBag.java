import java.util.Scanner;

public class SchoolBag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] items = new String[5];

        System.out.println("=== School Bag Manager ===");

        for (int i = 0; i < items.length; i++) {
            System.out.print("Enter item " + (i + 1) + ": ");
            items[i] = sc.nextLine();
        }

        System.out.println("\nItems in the School Bag:");
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + ". " + items[i]);
        }

        sc.close();
    }
}