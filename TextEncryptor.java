import java.io.*;
import java.util.Scanner;

public class TextEncryptor {
    // Method to encrypt text
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                result.append((char) ((c - base + shift) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // Method to decrypt text
    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift); // reverse shift
    }

    // Save text to file
    public static void saveToFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        }
    }

    // Read text from file
    public static String readFromFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter text:");
            String text = sc.nextLine();

            System.out.println("Enter shift value (1-25):");
            int shift = sc.nextInt();
            sc.nextLine(); // consume newline

            String encrypted = encrypt(text, shift);
            String decrypted = decrypt(encrypted, shift);

            System.out.println("\nEncrypted Text: " + encrypted);
            System.out.println("Decrypted Text: " + decrypted);

            saveToFile("encrypted.txt", encrypted);
            saveToFile("decrypted.txt", decrypted);

            System.out.println("\nFiles saved: encrypted.txt & decrypted.txt");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}