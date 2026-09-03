import java.util.*;

class Product {
    private String id;
    private String name;
    private int quantity;

    public Product(String id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }

    public void addStock(int amount) {
        quantity += amount;
    }

    public void removeStock(int amount) {
        if (amount <= quantity) {
            quantity -= amount;
        } else {
            System.out.println("Not enough stock to remove!");
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Quantity: " + quantity;
    }
}

public class WarehouseSystem {
    private static Map<String, Product> inventory = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Warehouse Management ---");
            System.out.println("1. Add Product");
            System.out.println("2. Update Stock");
            System.out.println("3. Remove Product");
            System.out.println("4. View Inventory");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> updateStock();
                case 3 -> removeProduct();
                case 4 -> viewInventory();
                case 5 -> {
                    System.out.println("Exiting system...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void addProduct() {
        System.out.print("Enter Product ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();
        sc.nextLine();

        inventory.put(id, new Product(id, name, qty));
        System.out.println("Product added successfully!");
    }

    private static void updateStock() {
        System.out.print("Enter Product ID: ");
        String id = sc.nextLine();
        Product p = inventory.get(id);

        if (p != null) {
            System.out.print("Enter amount to add (+) or remove (-): ");
            int amt = sc.nextInt();
            sc.nextLine();
            if (amt > 0) p.addStock(amt);
            else p.removeStock(-amt);
            System.out.println("Stock updated!");
        } else {
            System.out.println("Product not found!");
        }
    }

    private static void removeProduct() {
        System.out.print("Enter Product ID to remove: ");
        String id = sc.nextLine();
        if (inventory.remove(id) != null) {
            System.out.println("Product removed!");
        } else {
            System.out.println("Product not found!");
        }
    }

    private static void viewInventory() {
        if (inventory.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            System.out.println("\n--- Current Inventory ---");
            for (Product p : inventory.values()) {
                System.out.println(p);
            }
        }
    }
}
