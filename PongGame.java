import java.util.Scanner;
import java.util.Random;

public class PongGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int playerScore = 0;
        int computerScore = 0;
        int rounds = 5; // play 5 rounds

        System.out.println("🏓 Welcome to Pong!");
        System.out.println("Try to hit the ball back against the computer!");

        for (int i = 1; i <= rounds; i++) {
            System.out.println("\nRound " + i);
            System.out.print("Move paddle (Left=L, Right=R): ");
            char move = scanner.next().toUpperCase().charAt(0);

            // Ball direction
            char ballDirection = random.nextBoolean() ? 'L' : 'R';
            System.out.println("Ball comes from: " + (ballDirection == 'L' ? "Left" : "Right"));

            if ((move == 'L' && ballDirection == 'L') || (move == 'R' && ballDirection == 'R')) {
                System.out.println("🎯 You hit the ball!");
                playerScore++;
            } else {
                System.out.println("💨 You missed! Computer scores.");
                computerScore++;
            }
        }

        System.out.println("\nFinal Score: You " + playerScore + " | Computer " + computerScore);
        if (playerScore > computerScore) {
            System.out.println("🎉 You win!");
        } else if (playerScore < computerScore) {
            System.out.println("💀 Computer wins!");
        } else {
            System.out.println("🤝 It's a tie!");
        }

        scanner.close();
    }
}
