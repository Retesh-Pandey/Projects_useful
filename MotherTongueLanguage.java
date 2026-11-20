import java.util.Scanner;

public class MotherTongueLanguage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your mother tongue language:");
        String language = sc.nextLine();

        switch (language.toLowerCase()) {
            case "hindi":
                System.out.println("नमस्ते! आपकी मातृभाषा हिंदी है।");
                break;

            case "english":
                System.out.println("Hello! Your mother tongue is English.");
                break;

            case "tamil":
                System.out.println("வணக்கம்! உங்கள் தாய்மொழி தமிழ்.");
                break;

            case "telugu":
                System.out.println("నమస్కారం! మీ మాతృభాష తెలుగు.");
                break;

            case "bengali":
                System.out.println("নমস্কার! আপনার মাতৃভাষা বাংলা।");
                break;

            default:
                System.out.println("Language not available in the system.");
        }

        sc.close();
    }
}