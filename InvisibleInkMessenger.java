import java.util.*;

public class InvisibleInkMessenger {
    // Zero-width space and zero-width non-joiner
    private static final String ZERO = "\u200B"; 
    private static final String ONE = "\u200C"; 

    // Encode hidden message into cover text
    public static String encode(String coverText, String secret) {
        StringBuilder hidden = new StringBuilder();
        for (char c : secret.toCharArray()) {
            String binary = String.format("%8s", Integer.toBinaryString(c))
                                .replace(' ', '0');
            for (char bit : binary.toCharArray()) {
                hidden.append(bit == '0' ? ZERO : ONE);
            }
        }
        return coverText + hidden.toString();
    }

    // Decode hidden message
    public static String decode(String encodedText) {
        StringBuilder binary = new StringBuilder();
        for (char c : encodedText.toCharArray()) {
            if (c == '\u200B') binary.append("0");
            else if (c == '\u200C') binary.append("1");
        }

        StringBuilder secret = new StringBuilder();
        for (int i = 0; i < binary.length(); i += 8) {
            String byteStr = binary.substring(i, Math.min(i + 8, binary.length()));
            int charCode = Integer.parseInt(byteStr, 2);
            secret.append((char) charCode);
        }
        return secret.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Invisible Ink Messenger ===");
        System.out.print("Enter cover text: ");
        String cover = sc.nextLine();

        System.out.print("Enter secret message: ");
        String secret = sc.nextLine();

        String encoded = encode(cover, secret);
        System.out.println("\nEncoded Text (looks normal): " + encoded);

        System.out.println("Decoded Secret: " + decode(encoded));
        sc.close();
    }
}
