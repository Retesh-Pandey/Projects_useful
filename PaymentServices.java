import java.util.Scanner;

interface PaymentService {
    void pay(double amount);
}

class UPI implements PaymentService {
    public void pay(double amount) {
        System.out.println("UPI Payment Successful!");
        System.out.println("Amount Paid: ₹" + amount);
    }
}

class CreditCard implements PaymentService {
    public void pay(double amount) {
        System.out.println("Credit Card Payment Successful!");
        System.out.println("Amount Paid: ₹" + amount);
    }
}

class NetBanking implements PaymentService {
    public void pay(double amount) {
        System.out.println("Net Banking Payment Successful!");
        System.out.println("Amount Paid: ₹" + amount);
    }
}

public class PaymentServices {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Payment Service System =====");
        System.out.println("1. UPI");
        System.out.println("2. Credit Card");
        System.out.println("3. Net Banking");

        System.out.print("Choose Payment Method: ");
        int choice = sc.nextInt();

        System.out.print("Enter Amount: ₹");
        double amount = sc.nextDouble();

        PaymentService payment = null;

        switch (choice) {
            case 1:
                payment = new UPI();
                break;

            case 2:
                payment = new CreditCard();
                break;

            case 3:
                payment = new NetBanking();
                break;

            default:
                System.out.println("Invalid Choice!");
                System.exit(0);
        }

        payment.pay(amount);

        sc.close();
    }
}