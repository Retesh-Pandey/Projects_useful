import java.util.*;

class FDR {
    private String fdrId;
    private String customerName;
    private double depositAmount;
    private double interestRate;
    private int years;

    public FDR(String fdrId, String customerName,
               double depositAmount, double interestRate, int years) {
        this.fdrId = fdrId;
        this.customerName = customerName;
        this.depositAmount = depositAmount;
        this.interestRate = interestRate;
        this.years = years;
    }

    public String getFdrId() {
        return fdrId;
    }

    public double calculateMaturityAmount() {
        return depositAmount * Math.pow((1 + interestRate / 100), years);
    }

    public void display() {
        System.out.println("\n====== FDR DETAILS ======");
        System.out.println("FDR ID : " + fdrId);
        System.out.println("Customer Name : " + customerName);
        System.out.println("Deposit Amount : ₹" + depositAmount);
        System.out.println("Interest Rate : " + interestRate + "%");
        System.out.println("Duration : " + years + " Years");
        System.out.printf("Maturity Amount : ₹%.2f\n",
                          calculateMaturityAmount());
    }
}

public class FDRPortal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<FDR> fdrList = new ArrayList<>();

        while (true) {
            System.out.println("\n===== FDR PORTAL =====");
            System.out.println("1. Create FDR");
            System.out.println("2. View All FDRs");
            System.out.println("3. Search FDR");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter FDR ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Deposit Amount: ");
                    double amount = sc.nextDouble();

                    System.out.print("Enter Interest Rate (%): ");
                    double rate = sc.nextDouble();

                    System.out.print("Enter Duration (Years): ");
                    int years = sc.nextInt();

                    fdrList.add(new FDR(id, name, amount, rate, years));

                    System.out.println("FDR Created Successfully!");
                    break;

                case 2:
                    if (fdrList.isEmpty()) {
                        System.out.println("No FDR Records Found.");
                    } else {
                        for (FDR fdr : fdrList) {
                            fdr.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter FDR ID to Search: ");
                    String searchId = sc.nextLine();

                    boolean found = false;

                    for (FDR fdr : fdrList) {
                        if (fdr.getFdrId().equalsIgnoreCase(searchId)) {
                            fdr.display();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("FDR Not Found!");
                    }
                    break;

                case 4:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}