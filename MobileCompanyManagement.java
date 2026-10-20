import java.util.ArrayList;
import java.util.Scanner;

class Mobile {
    String model;
    double price;

    Mobile(String model, double price) {
        this.model = model;
        this.price = price;
    }

    void display() {
        System.out.println("Model: " + model + " | Price: ₹" + price);
    }
}

class MobileCompany {
    String companyName;
    ArrayList<Mobile> mobiles = new ArrayList<>();

    MobileCompany(String companyName) {
        this.companyName = companyName;
    }

    void addMobile(String model, double price) {
        mobiles.add(new Mobile(model, price));
        System.out.println("Mobile added successfully!");
    }

    void displayMobiles() {
        System.out.println("\nCompany: " + companyName);
        if (mobiles.isEmpty()) {
            System.out.println("No mobiles available.");
            return;
        }

        for (Mobile m : mobiles) {
            m.display();
        }
    }
}

public class MobileCompanyManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<MobileCompany> companies = new ArrayList<>();

        while (true) {
            System.out.println("\n===== Mobile Company Management =====");
            System.out.println("1. Add Company");
            System.out.println("2. Add Mobile");
            System.out.println("3. View Companies and Mobiles");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter company name: ");
                    String cname = sc.nextLine();
                    companies.add(new MobileCompany(cname));
                    System.out.println("Company added successfully!");
                    break;

                case 2:
                    if (companies.isEmpty()) {
                        System.out.println("Add a company first.");
                        break;
                    }

                    System.out.println("\nAvailable Companies:");
                    for (int i = 0; i < companies.size(); i++) {
                        System.out.println((i + 1) + ". " + companies.get(i).companyName);
                    }

                    System.out.print("Select company number: ");
                    int companyIndex = sc.nextInt() - 1;
                    sc.nextLine();

                    if (companyIndex >= 0 && companyIndex < companies.size()) {
                        System.out.print("Enter mobile model: ");
                        String model = sc.nextLine();

                        System.out.print("Enter price: ");
                        double price = sc.nextDouble();

                        companies.get(companyIndex).addMobile(model, price);
                    } else {
                        System.out.println("Invalid company selection.");
                    }
                    break;

                case 3:
                    if (companies.isEmpty()) {
                        System.out.println("No companies available.");
                    } else {
                        for (MobileCompany company : companies) {
                            company.displayMobiles();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Program exited.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}