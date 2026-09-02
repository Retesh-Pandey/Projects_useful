import java.util.*;

public class ExpenseSplitter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Double> expenses = new HashMap<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter amount paid by " + name + ": ");
            double amount = sc.nextDouble();
            sc.nextLine();
            expenses.put(name, amount);
        }

        double total = expenses.values().stream().mapToDouble(Double::doubleValue).sum();
        double share = total / n;

        System.out.println("\n--- Expense Summary ---");
        for (String name : expenses.keySet()) {
            double balance = expenses.get(name) - share;
            if (balance > 0) {
                System.out.println(name + " should receive ₹" + balance);
            } else if (balance < 0) {
                System.out.println(name + " should pay ₹" + (-balance));
            } else {
                System.out.println(name + " is settled.");
            }
        }
        sc.close();
    }
}
