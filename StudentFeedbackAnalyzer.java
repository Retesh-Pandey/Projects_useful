import java.util.*;

public class StudentFeedbackAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Simple word lists
        Set<String> positiveWords = new HashSet<>(Arrays.asList("good","great","excellent","helpful","amazing","nice"));
        Set<String> negativeWords = new HashSet<>(Arrays.asList("bad","poor","boring","confusing","slow","worst"));

        System.out.println("Enter student feedback:");
        String feedback = sc.nextLine().toLowerCase();

        // Split into words
        String[] words = feedback.split("\\s+");

        int positiveCount = 0, negativeCount = 0;
        for(String word : words) {
            if(positiveWords.contains(word)) positiveCount++;
            if(negativeWords.contains(word)) negativeCount++;
        }

        System.out.println("\n--- Feedback Analysis ---");
        System.out.println("Positive words: " + positiveCount);
        System.out.println("Negative words: " + negativeCount);

        if(positiveCount > negativeCount) {
            System.out.println("Overall Sentiment: Positive 😊");
        } else if(negativeCount > positiveCount) {
            System.out.println("Overall Sentiment: Negative 😟");
        } else {
            System.out.println("Overall Sentiment: Neutral 😐");
        }

        sc.close();
    }
}
