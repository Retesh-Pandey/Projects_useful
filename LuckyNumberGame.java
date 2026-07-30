import java.util.Scanner;

public class LuckyNumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input names
        System.out.print("Enter first name: ");
        String name1 = sc.nextLine().toLowerCase().replaceAll("\\s+", "");
        System.out.print("Enter second name: ");
        String name2 = sc.nextLine().toLowerCase().replaceAll("\\s+", "");

        // Calculate numeric value of each name
        int sum1 = 0, sum2 = 0;
        for (char c : name1.toCharArray()) {
            sum1 += c - 'a' + 1; // a=1, b=2, ...
        }
        for (char c : name2.toCharArray()) {
            sum2 += c - 'a' + 1;
        }

        // Reduce to single digit (lucky number)
        int lucky1 = reduceToSingleDigit(sum1);
        int lucky2 = reduceToSingleDigit(sum2);

        // Compatibility check
        int diff = Math.abs(lucky1 - lucky2);
        String result;
        if (diff == 0) {
            result = "Perfect Match!";
        } else if (diff <= 2) {
            result = "Strong Compatibility";
        } else if (diff <= 4) {
            result = "Moderate Compatibility";
        } else {
            result = "Low Compatibility";
        }

        // Output
        System.out.println(name1 + " Lucky Number: " + lucky1);
        System.out.println(name2 + " Lucky Number: " + lucky2);
        System.out.println("Result: " + result);

        sc.close();
    }

    // Helper method to reduce sum to single digit
    private static int reduceToSingleDigit(int num) {
        while (num > 9) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
}
