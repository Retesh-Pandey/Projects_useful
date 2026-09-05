import java.util.*;

class LaundryOrder {
    private String customerName;
    private int clothesCount;
    private double pricePerCloth;
    private boolean isCompleted;

    public LaundryOrder(String customerName, int clothesCount, double pricePerCloth) {
        this.customerName = customerName;
        this.clothesCount = clothesCount;
        this.pricePerCloth = pricePerCloth;
        this.isCompleted = false;
    }

    public String getCustomerName() { return customerName; }
    public int getClothesCount() { return clothesCount; }
    public double getTotalBill() { return clothesCount * pricePerCloth; }
    public boolean isCompleted() { return isCompleted; }

    public void markCompleted() {
        isCompleted = true;
    }

    @Override
    public String toString() {
        return "Customer: " + customerName +
               ", Clothes: " + clothesCount +
               ", Bill: ₹" + getTotalBill() +
               ", Status: " + (isCompleted ? "Completed" : "Pending");
    }
}

public class LaundryCompany {
    private static List<LaundryOrder> orders = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n--- Laundry Company Menu ---");
            System.out.println("1. Add Laundry Order");
            System.out.println("2. View All Orders");
            System.out.println("3. Mark Order as Completed");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addOrder();
                    break;
                case 2:
                    viewOrders();
                    break;
                case 3:
                    completeOrder();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting Laundry Company System...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }

    private static void addOrder() {
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();
        System.out.print("Enter number of clothes: ");
        int count = sc.nextInt();
        System.out.print("Enter price per cloth: ");
        double price = sc.nextDouble();
        sc.nextLine();

        LaundryOrder order = new LaundryOrder(name, count, price);
        orders.add(order);
        System.out.println("Order added successfully!");
    }

    private static void viewOrders() {
        System.out.println("\n--- Orders ---");
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
        } else {
            for (int i = 0; i < orders.size(); i++) {
                System.out.println((i + 1) + ". " + orders.get(i));
            }
        }
    }

    private static void completeOrder() {
        viewOrders();
        if (!orders.isEmpty()) {
            System.out.print("Enter order number to mark completed: ");
            int orderNum = sc.nextInt();
            sc.nextLine();
            if (orderNum > 0 && orderNum <= orders.size()) {
                orders.get(orderNum - 1).markCompleted();
                System.out.println("Order marked as completed!");
            } else {
                System.out.println("Invalid order number!");
            }
        }
    }
}
