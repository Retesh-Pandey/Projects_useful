import java.util.*;

class MovieFinance {
    String title;
    double budget;
    double boxOffice;

    MovieFinance(String title, double budget, double boxOffice) {
        this.title = title;
        this.budget = budget;
        this.boxOffice = boxOffice;
    }

    double getProfit() {
        return boxOffice - budget;
    }

    void showFinance() {
        System.out.println("🎬 Movie: " + title);
        System.out.println("💰 Budget: $" + budget);
        System.out.println("🎟️ Box Office: $" + boxOffice);
        System.out.println("📈 Profit: $" + getProfit());
        if (getProfit() > 0) {
            System.out.println("✅ This movie was profitable!");
        } else {
            System.out.println("❌ This movie lost money.");
        }
    }
}

public class MovieBudgetCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<MovieFinance> movies = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Movie Budget & Profit Calculator ---");
            System.out.println("1. Add movie finance details");
            System.out.println("2. Show movie finance report");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter movie title: ");
                String title = sc.nextLine();

                System.out.print("Enter budget ($): ");
                double budget = sc.nextDouble();

                System.out.print("Enter box office collection ($): ");
                double boxOffice = sc.nextDouble();
                sc.nextLine();

                movies.add(new MovieFinance(title, budget, boxOffice));
                System.out.println("✅ Movie finance added!");
            } else if (choice == 2) {
                System.out.print("Enter movie title: ");
                String title = sc.nextLine();
                boolean found = false;
                for (MovieFinance m : movies) {
                    if (m.title.equalsIgnoreCase(title)) {
                        m.showFinance();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("❌ Movie not found.");
                }
            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            }
        }
        sc.close();
    }
}
