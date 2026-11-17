import java.util.Scanner;

public class DesignProjectEstimator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Graphic Design Cost Estimator ===");

        System.out.print("Enter Project Name: ");
        String projectName = sc.nextLine();

        System.out.print("Enter Number of Design Hours: ");
        int hours = sc.nextInt();

        System.out.print("Enter Cost per Hour (₹): ");
        double rate = sc.nextDouble();

        System.out.print("Need Premium Graphics? (1-Yes, 0-No): ");
        int premium = sc.nextInt();

        double totalCost = hours * rate;

        if (premium == 1) {
            totalCost += 1000; // Premium graphics charge
        }

        System.out.println("\n----- DESIGN PROJECT REPORT -----");
        System.out.println("Project Name : " + projectName);
        System.out.println("Design Hours : " + hours);
        System.out.println("Rate/Hour    : ₹" + rate);

        if (premium == 1) {
            System.out.println("Premium Graphics : Added");
        } else {
            System.out.println("Premium Graphics : Not Added");
        }

        System.out.println("Total Cost   : ₹" + totalCost);
        System.out.println("Project Ready for Client!");
        
        sc.close();
    }
}