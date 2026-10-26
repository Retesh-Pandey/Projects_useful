import java.util.Random;
import java.util.Scanner;

public class LearningJava {
    
    static int generateNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    static void checkGuess(int guess, int number) {
        if (guess > number) {
            System.out.println("Too High!");
        } else if (guess < number) {
            System.out.println("Too Low!");
        } else {
            System.out.println("Correct Guess!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = generateNumber();
        int guess;
        int attempts = 0;

        System.out.println("=== Number Guessing Game ===");
        System.out.println("Guess a number between 1 and 100");

        do {
            System.out.print("Enter your guess: ");
            guess = sc.nextInt();
            attempts++;

            checkGuess(guess, number);

        } while (guess != number);

        System.out.println("You guessed it in " + attempts + " attempts!");

        sc.close();
    }
}