import java.util.*;

public class SentimentAnalyzer {
    private Map<String, Integer> positiveWords = new HashMap<>();
    private Map<String, Integer> negativeWords = new HashMap<>();
    private int totalPositive = 0;
    private int totalNegative = 0;

    // Train with labeled data
    public void train(String text, boolean isPositive) {
        String[] words = text.toLowerCase().split("\\W+");
        for (String word : words) {
            if (isPositive) {
                positiveWords.put(word, positiveWords.getOrDefault(word, 0) + 1);
                totalPositive++;
            } else {
                negativeWords.put(word, negativeWords.getOrDefault(word, 0) + 1);
                totalNegative++;
            }
        }
    }

    // Predict sentiment
    public String predict(String text) {
        String[] words = text.toLowerCase().split("\\W+");
        double posScore = Math.log(totalPositive + 1);
        double negScore = Math.log(totalNegative + 1);

        for (String word : words) {
            posScore += Math.log(positiveWords.getOrDefault(word, 1));
            negScore += Math.log(negativeWords.getOrDefault(word, 1));
        }

        return posScore > negScore ? "Positive 😊" : "Negative 😡";
    }

    public static void main(String[] args) {
        SentimentAnalyzer analyzer = new SentimentAnalyzer();

        // Training data
        analyzer.train("I love this product, it is amazing", true);
        analyzer.train("This is the worst experience ever", false);
        analyzer.train("Absolutely fantastic service", true);
        analyzer.train("I hate waiting so long", false);

        // Predictions
        System.out.println(analyzer.predict("The movie was great and fun"));
        System.out.println(analyzer.predict("Terrible food and bad service"));
    }
}
