import java.util.*;

public class SpamClassifier {
    // Simple dataset (training samples)
    static String[] spamSamples = {
        "Win money now", "Free lottery ticket", "Claim your prize",
        "Congratulations you won", "Get rich quick"
    };
    static String[] hamSamples = {
        "Meeting at 5pm", "Project deadline tomorrow", "Lunch with team",
        "Can we reschedule?", "See you in class"
    };

    // Word frequency maps
    static Map<String, Integer> spamWords = new HashMap<>();
    static Map<String, Integer> hamWords = new HashMap<>();
    static int spamCount = 0, hamCount = 0;

    public static void main(String[] args) {
        train(spamSamples, spamWords, true);
        train(hamSamples, hamWords, false);

        Scanner sc = new Scanner(System.in);
        System.out.println("=== AI Spam Classifier ===");
        System.out.print("Enter a message: ");
        String msg = sc.nextLine();

        String result = classify(msg);
        System.out.println("Prediction: " + result);
        sc.close();
    }

    // Training function
    static void train(String[] samples, Map<String, Integer> wordMap, boolean isSpam) {
        for (String s : samples) {
            for (String word : s.toLowerCase().split(" ")) {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }
            if (isSpam) spamCount++; else hamCount++;
        }
    }

    // Classification using Naive Bayes idea
    static String classify(String msg) {
        double spamScore = Math.log((double) spamCount / (spamCount + hamCount));
        double hamScore = Math.log((double) hamCount / (spamCount + hamCount));

        for (String word : msg.toLowerCase().split(" ")) {
            spamScore += Math.log((spamWords.getOrDefault(word, 1)) / (double)(spamCount + 1));
            hamScore += Math.log((hamWords.getOrDefault(word, 1)) / (double)(hamCount + 1));
        }

        return spamScore > hamScore ? "Spam 🚨" : "Not Spam ✅";
    }
}
