import java.util.*;

class Movie {
    String title;
    String genre;

    Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }
}

public class MovieRecommendationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sample movie database
        List<Movie> movies = Arrays.asList(
            new Movie("Inception", "Sci-Fi"),
            new Movie("The Dark Knight", "Action"),
            new Movie("Interstellar", "Sci-Fi"),
            new Movie("La La Land", "Romance"),
            new Movie("Parasite", "Thriller"),
            new Movie("Avengers: Endgame", "Action"),
            new Movie("Titanic", "Romance"),
            new Movie("The Shawshank Redemption", "Drama")
        );

        System.out.println("🎬 Welcome to Movie Recommendation System!");
        System.out.print("Enter your favorite genre (e.g., Action, Sci-Fi, Romance, Drama, Thriller): ");
        String genre = sc.nextLine();

        System.out.println("\n✨ Recommended Movies in " + genre + " genre:");
        boolean found = false;
        for (Movie m : movies) {
            if (m.genre.equalsIgnoreCase(genre)) {
                System.out.println("- " + m.title);
                found = true;
            }
        }

        if (!found) {
            System.out.println("❌ Sorry, no movies found in this genre.");
        }

        sc.close();
    }
}
