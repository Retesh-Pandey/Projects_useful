import java.util.Random;
import java.util.Scanner;

public class FuturePredictor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] predictions = {
            "You will have a great day!",
            "A surprise is waiting for you.",
            "Hard work will pay off soon.",
            "Someone special will contact you.",
            "Be cautious with decisions today.",
            "An opportunity will knock on your door.",
            "Happiness is coming your way.",
            "You will achieve your goals."
        };

        System.out.println("🔮 Welcome to the Future Predictor!");
        System.out.print("Ask a question about your future: ");
        scanner.nextLine(); // Just to simulate asking

        int index = random.nextInt(predictions.length);
        System.out.println("Prediction: " + predictions[index]);

        scanner.close();
    }
}
