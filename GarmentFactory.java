import java.util.*;

class Garment {
    private String name;
    private String size;
    private double price;
    private int quantity;

    public Garment(String name, String size, double price, int quantity) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public String getSize() { return size; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void addStock(int amount) {
        quantity += amount;
    }

    public boolean sell(int amount) {
        if (amount <= quantity) {
            quantity -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return name + " (Size: " + size + ", Price: ₹" + price + ", Stock: " + quantity + ")";
    }
}

public class GarmentFactory {
    private static Map<String, Garment> inventory = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Garment Factory Menu ---");
            System.out.println("1. Add Garment");
            System.out.println("2. View Inventory");
            System.out.println("3. Sell Garment");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter garment name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter size: ");
                    String size = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();
                    sc.nextLine();

                    inventory.put(name, new Garment(name, size, price, qty));
                    System.out.println("Garment added successfully!");
                    break;

                case 2:
                    System.out.println("\n--- Inventory ---");
                    for (Garment g : inventory.values()) {
                        System.out.println(g);
                    }
                    break;

                case 3:
                    System.out.print("Enter garment name to sell: ");
                    String sellName = sc.nextLine();
                    if (inventory.containsKey(sellName)) {
                        System.out.print("Enter quantity to sell: ");
                        int sellQty = sc.nextInt();
                        sc.nextLine();
                        if (inventory.get(sellName).sell(sellQty)) {
                            System.out.println("Sold " + sellQty + " " + sellName + "(s).");
                        } else {
                            System.out.println("Not enough stock!");
                        }
                    } else {
                        System.out.println("Garment not found!");
                    }
                    break;

                case 4:
                    running = false;
                    System.out.println("Exiting Garment Factory System...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}
