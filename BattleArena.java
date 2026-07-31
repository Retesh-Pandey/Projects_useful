import java.util.Random;
import java.util.Scanner;

public class BattleArena {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int playerHealth = 100;
        int enemyHealth = 100;

        System.out.println("⚔️ Welcome to the Battle Arena!");
        System.out.println("You face a mighty enemy warrior!");
        
        while (playerHealth > 0 && enemyHealth > 0) {
            System.out.println("\nYour Health: " + playerHealth + " | Enemy Health: " + enemyHealth);
            System.out.println("Choose your move:");
            System.out.println("1. Attack");
            System.out.println("2. Defend");
            System.out.println("3. Heal");

            int choice = sc.nextInt();

            int enemyMove = rand.nextInt(3) + 1; // Enemy randomly chooses

            if (choice == 1) { // Attack
                int damage = rand.nextInt(20) + 5;
                enemyHealth -= damage;
                System.out.println("You strike the enemy for " + damage + " damage!");
            } else if (choice == 2) { // Defend
                System.out.println("You brace yourself for the attack!");
            } else if (choice == 3) { // Heal
                int heal = rand.nextInt(15) + 5;
                playerHealth += heal;
                System.out.println("You heal yourself for " + heal + " points!");
            }

            // Enemy move
            if (enemyMove == 1) {
                int damage = rand.nextInt(20) + 5;
                if (choice == 2) {
                    damage /= 2; // Defend reduces damage
                    System.out.println("Enemy attacks, but you block part of it!");
                }
                playerHealth -= damage;
                System.out.println("Enemy hits you for " + damage + " damage!");
            } else if (enemyMove == 2) {
                System.out.println("Enemy defends cautiously.");
            } else {
                int heal = rand.nextInt(15) + 5;
                enemyHealth += heal;
                System.out.println("Enemy heals for " + heal + " points!");
            }
        }

        if (playerHealth <= 0 && enemyHealth <= 0) {
            System.out.println("\nIt's a draw! Both warriors fall.");
        } else if (playerHealth <= 0) {
            System.out.println("\nYou have been defeated...");
        } else {
            System.out.println("\nVictory! You defeated the enemy!");
        }

        sc.close();
    }
}
