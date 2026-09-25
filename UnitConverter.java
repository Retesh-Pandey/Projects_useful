import java.util.Scanner;

public class UnitConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("📏 Welcome to Unit Converter!");
        System.out.println("Choose conversion type:");
        System.out.println("1. Kilometers to Miles");
        System.out.println("2. Miles to Kilometers");
        System.out.println("3. Celsius to Fahrenheit");
        System.out.println("4. Fahrenheit to Celsius");
        System.out.println("5. Kilograms to Pounds");
        System.out.println("6. Pounds to Kilograms");

        int choice = sc.nextInt();
        System.out.print("Enter value: ");
        double value = sc.nextDouble();

        double result = 0;
        switch (choice) {
            case 1: result = value * 0.621371; break;
            case 2: result = value / 0.621371; break;
            case 3: result = (value * 9/5) + 32; break;
            case 4: result = (value - 32) * 5/9; break;
            case 5: result = value * 2.20462; break;
            case 6: result = value / 2.20462; break;
            default: System.out.println("Invalid choice!"); return;
        }

        System.out.println("Converted Value: " + result);
        sc.close();
    }
}
