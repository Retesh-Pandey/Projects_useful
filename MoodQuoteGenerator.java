import java.util.Scanner;
import java.util.HashMap;

public class MoodQuoteGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Store mood → quote mapping
        HashMap<String, String> quotes = new HashMap<>();
        quotes.put("happy", "Happiness is not something ready made. It comes from your own actions.");
        quotes.put("sad", "Stars can’t shine without darkness.");
        quotes.put("stressed", "Take a deep breath. You’re stronger than you think.");
        quotes.put("motivated", "Don’t watch the clock; do what it does. Keep going.");
        quotes.put("angry", "For every minute you are angry, you lose sixty seconds of happiness.");

        System.out.print("Enter your mood (happy/sad/stressed/motivated/angry): ");
        String mood = sc.nextLine().toLowerCase();

        if (quotes.containsKey(mood)) {
            System.out.println("\nHere’s a quote for you:");
            System.out.println(quotes.get(mood));
        } else {
            System.out.println("\nSorry, I don’t have a quote for that mood yet.");
        }
    }
}
