import java.util.Random;
import java.util.Scanner;

public class StandupComedyGenerator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] setups = {
                "I tried learning programming",
                "My friend joined a gym",
                "I bought a smart phone",
                "My teacher loves online classes",
                "I started eating healthy food",
                "I asked AI for life advice",
                "My laptop and I have a special relationship"
        };

        String[] punchlines = {
                "but the bugs learned me instead!",
                "now he only exercises his fingers scrolling social media.",
                "it became smarter than me within two days.",
                "because mute buttons save lives.",
                "my pizza delivery guy got worried.",
                "now even my mistakes come with explanations.",
                "we both freeze under pressure."
        };

        System.out.println("=== Virtual Stand-Up Comedian ===");
        System.out.print("How many jokes do you want? ");
        int n = sc.nextInt();

        System.out.println("\n🎤 Welcome to Comedy Night! 🎤\n");

        for (int i = 1; i <= n; i++) {
            int setupIndex = random.nextInt(setups.length);
            int punchIndex = random.nextInt(punchlines.length);

            System.out.println("Joke " + i + ":");
            System.out.println(setups[setupIndex] + ", " + punchlines[punchIndex]);
            System.out.println();
        }

        System.out.println("😂 Thank you! Don't forget to tip your programmer!");
        sc.close();
    }
}