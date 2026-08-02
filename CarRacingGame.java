import java.util.Random;
import java.util.Scanner;

public class CarRacingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int playerPosition = 0;
        int computerPosition = 0;
        int finishLine = 50; // distance to win

        System.out.println("🏎️ Welcome to the Car Racing Game!");
        System.out.println("First to reach " + finishLine + " wins!");

        while (playerPosition < finishLine && computerPosition < finishLine) {
            System.out.println("\nPress ENTER to accelerate...");
            scanner.nextLine();

            // Player move
            int playerMove = random.nextInt(6) + 1; // 1–6 steps
            playerPosition += playerMove;
            System.out.println("🚗 You moved " + playerMove + " steps. Position: " + playerPosition);

            // Computer move
            int computerMove = random.nextInt(6) + 1;
            computerPosition += computerMove;
            System.out.println("🤖 Computer moved " + computerMove + " steps. Position: " + computerPosition);
        }

        if (playerPosition >= finishLine && computerPosition >= finishLine) {
            System.out.println("🤝 It's a tie!");
        } else if (playerPosition >= finishLine) {
            System.out.println("🎉 You win the race!");
        } else {
            System.out.println("💀 Computer wins the race!");
        }

        scanner.close();
    }
}
