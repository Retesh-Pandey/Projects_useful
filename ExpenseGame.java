import java.util.Random;
import java.util.Scanner;

public class ExpenseGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int balance = 500; // starting money
        int round = 1;

        System.out.println("💰 Welcome to Life Budget Challenge!");
        System.out.println("You start with $" + balance);

        while (balance > 0) {
            System.out.println("\n--- Round " + round + " ---");
            System.out.println("Current Balance: $" + balance);

            // Random event
            String[] events = {"Bought a gadget", "Paid rent", "Got a fine", "Won a lottery", "Received salary"};
            int eventIndex = rand.nextInt(events.length);
            String event = events[eventIndex];

            int amount;
            if (event.equals("Won a lottery") || event.equals("Received salary")) {
                amount = rand.nextInt(200) + 50;
                balance += amount;
                System.out.println(event + "! You gained $" + amount);
            } else {
                amount = rand.nextInt(150) + 30;
                balance -= amount;
                System.out.println(event + "! You lost $" + amount);
            }

            // Player choice
            System.out.println("Do you want to (1) Save or (2) Spend $50 on fun?");
            int choice = sc.nextInt();
            if (choice == 2) {
                balance -= 50;
                System.out.println("You enjoyed life but spent $50!");
            } else {
                System.out.println("You saved wisely!");
            }

            round++;
        }

        System.out.println("\n💀 Game Over! You ran out of money.");
        sc.close();
    }
}
