import java.util.*;

class Movie {
    String title;
    List<Integer> ratings = new ArrayList<>();
    List<String> reviews = new ArrayList<>();

    Movie(String title) {
        this.title = title;
    }

    void addReview(int rating, String review) {
        ratings.add(rating);
        reviews.add(review);
    }

    double getAverageRating() {
        if (ratings.isEmpty()) return 0.0;
        int sum = 0;
        for (int r : ratings) sum += r;
        return (double) sum / ratings.size();
    }

    void showDetails() {
        System.out.println("🎬 Movie: " + title);
        System.out.println("⭐ Average Rating: " + getAverageRating());
        System.out.println("📝 Reviews:");
        for (String r : reviews) {
            System.out.println("- " + r);
        }
    }
}

public class MovieReviewSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Movie> movies = new HashMap<>();

        while (true) {
            System.out.println("\n--- Movie Review System ---");
            System.out.println("1. Add a movie review");
            System.out.println("2. Show movie details");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter movie title: ");
                String title = sc.nextLine();
                movies.putIfAbsent(title, new Movie(title));

                System.out.print("Enter rating (1-5): ");
                int rating = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter your review: ");
                String review = sc.nextLine();

                movies.get(title).addReview(rating, review);
                System.out.println("✅ Review added!");
            } else if (choice == 2) {
                System.out.print("Enter movie title: ");
                String title = sc.nextLine();
                Movie m = movies.get(title);
                if (m != null) {
                    m.showDetails();
                } else {
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
