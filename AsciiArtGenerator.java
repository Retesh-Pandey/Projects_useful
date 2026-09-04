import java.util.Scanner;

public class AsciiArtGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("🎨 Welcome to ASCII Art Generator!");
        System.out.print("Enter text to convert: ");
        String input = scanner.nextLine();

        generateAsciiArt(input);
    }

    private static void generateAsciiArt(String text) {
        String[] letters = {
            "  ___   ", " |   |  ", " |___|  ", // A
            " ____   ", " |   \\  ", " |___/  ", // B
            "  ____  ", " |      ", " |____  "  // C
            // 👉 You can expand this mapping for all letters
        };

        for (char c : text.toUpperCase().toCharArray()) {
            if (c == 'A') {
                System.out.println(letters[0]);
                System.out.println(letters[1]);
                System.out.println(letters[2]);
            } else if (c == 'B') {
                System.out.println(letters[3]);
                System.out.println(letters[4]);
                System.out.println(letters[5]);
            } else if (c == 'C') {
                System.out.println(letters[6]);
                System.out.println(letters[7]);
                System.out.println(letters[8]);
            } else {
                System.out.println(c); // fallback
            }
        }
    }
}
