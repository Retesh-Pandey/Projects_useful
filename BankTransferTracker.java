import java.util.ArrayList;
import java.util.Scanner;

class Transfer {
    String transferId;
    String senderAccount;
    String receiverAccount;
    double amount;
    String date;
    String status;

    Transfer(String transferId, String senderAccount,
             String receiverAccount, double amount,
             String date, String status) {
        this.transferId = transferId;
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
        this.amount = amount;
        this.date = date;
        this.status = status;
    }

    void display() {
        System.out.println("\nTransfer ID : " + transferId);
        System.out.println("Sender      : " + senderAccount);
        System.out.println("Receiver    : " + receiverAccount);
        System.out.println("Amount      : ₹" + amount);
        System.out.println("Date        : " + date);
        System.out.println("Status      : " + status);
    }
}

public class BankTransferTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Transfer> transfers = new ArrayList<>();

        while (true) {
            System.out.println("\n===== Bank Transfer Tracker =====");
            System.out.println("1. Add Transfer");
            System.out.println("2. View All Transfers");
            System.out.println("3. Search Transfer");
            System.out.println("4. Update Status");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Transfer ID: ");
                    String id = sc.nextLine();

                    System.out.print("Sender Account: ");
                    String sender = sc.nextLine();

                    System.out.print("Receiver Account: ");
                    String receiver = sc.nextLine();

                    System.out.print("Amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Date (DD-MM-YYYY): ");
                    String date = sc.nextLine();

                    System.out.print("Status (Pending/Completed/Failed): ");
                    String status = sc.nextLine();

                    transfers.add(new Transfer(
                            id, sender, receiver,
                            amount, date, status));

                    System.out.println("Transfer Added Successfully!");
                    break;

                case 2:
                    if (transfers.isEmpty()) {
                        System.out.println("No Transfers Found.");
                    } else {
                        for (Transfer t : transfers) {
                            t.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Transfer ID: ");
                    String searchId = sc.nextLine();

                    boolean found = false;
                    for (Transfer t : transfers) {
                        if (t.transferId.equalsIgnoreCase(searchId)) {
                            t.display();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Transfer Not Found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Transfer ID: ");
                    String updateId = sc.nextLine();

                    found = false;
                    for (Transfer t : transfers) {
                        if (t.transferId.equalsIgnoreCase(updateId)) {
                            System.out.print("New Status: ");
                            t.status = sc.nextLine();
                            System.out.println("Status Updated!");
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Transfer Not Found!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}