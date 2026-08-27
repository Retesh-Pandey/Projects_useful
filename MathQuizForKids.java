import java.util.Scanner;
import java.util.Random;

public class MathQuizForKids {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int score = 0;
        int totalQuestions = 5; // You can change this number

        System.out.println("🎉 Welcome to the Math Quiz Game!");
        System.out.println("Answer the questions to test your skills.\n");

        for (int i = 1; i <= totalQuestions; i++) {
            int num1 = rand.nextInt(10) + 1; // numbers between 1–10
            int num2 = rand.nextInt(10) + 1;
            int operation = rand.nextInt(4); // 0=+, 1=-, 2=*, 3=/

            int correctAnswer = 0;
            String question = "";

            switch (operation) {
                case 0:
                    correctAnswer = num1 + num2;
                    question = num1 + " + " + num2;
                    break;
                case 1:
                    correctAnswer = num1 - num2;
                    question = num1 + " - " + num2;
                    break;
                case 2:
                    correctAnswer = num1 * num2;
                    question = num1 + " * " + num2;
                    break;
                case 3:
                    correctAnswer = num1 / num2;
                    question = num1 + " / " + num2;
                    break;
            }

            System.out.print("Q" + i + ": What is " + question + " ? ");
            int userAnswer = sc.nextInt();

            if (userAnswer == correctAnswer) {
                System.out.println("✅ Correct!\n");
                score++;
            } else {
                System.out.println("❌ Oops! The right answer is " + correctAnswer + "\n");
            }
        }

        System.out.println("🎯 Quiz Over! Your score: " + score + "/" + totalQuestions);
        if (score == totalQuestions) {
            System.out.println("🏆 Excellent! You got all correct!");
        } else if (score >= totalQuestions / 2) {
            System.out.println("👍 Good job! Keep practicing.");
        } else {
            System.out.println("📚 Don’t worry, practice makes perfect!");
        }

        sc.close();
    }
}
