import java.util.Scanner;

public class FlamesGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input
        System.out.print("Enter first name: ");
        String name1 = sc.nextLine().toLowerCase().replaceAll("\\s+", "");
        System.out.print("Enter second name: ");
        String name2 = sc.nextLine().toLowerCase().replaceAll("\\s+", "");

        // Remove common characters
        StringBuilder sb1 = new StringBuilder(name1);
        StringBuilder sb2 = new StringBuilder(name2);

        for (int i = 0; i < sb1.length(); i++) {
            char ch = sb1.charAt(i);
            int index = sb2.indexOf(String.valueOf(ch));
            if (index != -1) {
                sb1.deleteCharAt(i);
                sb2.deleteCharAt(index);
                i--; // adjust index after deletion
            }
        }

        // Count remaining letters
        int count = sb1.length() + sb2.length();

        // FLAMES logic
        String flames = "FLAMES";
        StringBuilder result = new StringBuilder(flames);

        int pos = 0;
        while (result.length() > 1) {
            pos = (pos + count - 1) % result.length();
            result.deleteCharAt(pos);
        }

        // Final relationship
        char outcome = result.charAt(0);
        String relation = "";
        switch (outcome) {
            case 'F': relation = "Friends"; break;
            case 'L': relation = "Love"; break;
            case 'A': relation = "Affection"; break;
            case 'M': relation = "Marriage"; break;
            case 'E': relation = "Enemies"; break;
            case 'S': relation = "Siblings"; break;
        }

        System.out.println("Result: " + relation);
        sc.close();
    }
}
