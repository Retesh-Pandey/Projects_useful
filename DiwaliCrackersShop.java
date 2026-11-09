import java.util.Scanner;

public class DiwaliCrackersShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] crackers = {
                "Sparklers",
                "Flower Pots",
                "Rockets",
                "Ground Chakkars",
                "Bombs"
        };

        int[] prices = {50, 120, 200, 80, 150};

        double total = 0;

        System.out.println("=== DIWALI CRACKERS SHOP ===");

        for (int i = 0; i < crackers.length; i++) {
            System.out.print("Enter quantity of " + crackers[i] + ": ");
            int qty = sc.nextInt();
            total += qty * prices[i];
        }

        double discount = 0;

        if (total >= 5000) {
            discount = total * 0.15;
        } else if (total >= 3000) {
            discount = total * 0.10;
        }

        double finalAmount = total - discount;

        System.out.println("\n----- BILL -----");
        System.out.println("Total Amount : ₹" + total);
        System.out.println("Discount     : ₹" + discount);
        System.out.println("Payable Amt  : ₹" + finalAmount);
        System.out.println("----------------");
    }
}