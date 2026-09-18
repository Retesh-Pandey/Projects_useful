import java.util.Scanner;

public class LoanCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input values
        System.out.print("Enter loan amount (principal): ");
        double principal = sc.nextDouble();

        System.out.print("Enter annual interest rate (in %): ");
        double annualRate = sc.nextDouble();

        System.out.print("Enter loan term (in years): ");
        int years = sc.nextInt();

        // Convert annual rate to monthly and years to months
        double monthlyRate = annualRate / 100 / 12;
        int months = years * 12;

        // Formula for monthly payment
        double monthlyPayment = (principal * monthlyRate) /
                (1 - Math.pow(1 + monthlyRate, -months));

        // Output
        System.out.printf("Monthly Payment: %.2f\n", monthlyPayment);
        System.out.printf("Total Payment: %.2f\n", monthlyPayment * months);

        sc.close();
    }
}
