import java.util.Random;
import java.util.Scanner;

public class IcebreakerGenerator {
    public static void main(String[] args) {
        String[] prompts = {
            "If you could relive one year of your life, which would it be?",
            "What’s a skill you’ve always wanted to learn?",
            "If you had a time machine, where would you go first?",
            "What’s the most unusual food you’ve ever tried?",
            "If you could instantly master any hobby, what would it be?",
            "What’s one movie you think everyone should watch at least once?",
            "If you could swap lives with someone for a day, who would it be?",
            "What’s a childhood memory that always makes you smile?",
            "If you had to give a TED talk tomorrow, what topic would you choose?",
            "What’s the most underrated joy in adult life?"
        };

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("✨ Welcome to the Icebreaker Generator!");
        System.out.println("Press ENTER to get a conversation starter, or type 'exit' to quit.");

        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye! May your conversations flow smoothly.");
                break;
            }
            int index = rand.nextInt(prompts.length);
            System.out.println("👉 " + prompts[index]);
        }
    }
}
