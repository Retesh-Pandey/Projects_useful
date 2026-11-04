import java.util.*;

class Accessory {
    String name;
    String category;
    double price;
    int rating;

    Accessory(String name, String category, double price, int rating) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.rating = rating;
    }

    void display() {
        System.out.println("\nName: " + name);
        System.out.println("Category: " + category);
        System.out.println("Price: $" + price);
        System.out.println("Rating: " + rating + "/5");
    }
}

public class ComputerAccessoriesPortal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Accessory> accessories = new ArrayList<>();
        accessories.add(new Accessory("Mechanical Keyboard", "Keyboard", 79.99, 5));
        accessories.add(new Accessory("Gaming Mouse", "Mouse", 49.99, 4));
        accessories.add(new Accessory("HD Webcam", "Webcam", 65.50, 5));
        accessories.add(new Accessory("Wireless Headset", "Headset", 89.99, 4));
        accessories.add(new Accessory("27-inch Monitor", "Monitor", 199.99, 5));

        System.out.println("=== Computer Accessories Portal ===");
        System.out.print("Enter accessory category: ");
        String searchCategory = sc.nextLine();

        boolean found = false;

        for (Accessory a : accessories) {
            if (a.category.equalsIgnoreCase(searchCategory)) {
                a.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No accessories found in this category.");
        }

        sc.close();
    }
}