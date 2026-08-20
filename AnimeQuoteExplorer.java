import java.util.*;

class AnimeQuoteExplorer {
    static class Quote {
        String anime;
        String character;
        String text;

        Quote(String anime, String character, String text) {
            this.anime = anime;
            this.character = character;
            this.text = text;
        }

        @Override
        public String toString() {
            return "\"" + text + "\" - " + character + " (" + anime + ")";
        }
    }

    public static void main(String[] args) {
        List<Quote> quotes = new ArrayList<>();
        quotes.add(new Quote("Naruto", "Naruto Uzumaki", "I never give up!"));
        quotes.add(new Quote("One Piece", "Monkey D. Luffy", "I’m gonna be King of the Pirates!"));
        quotes.add(new Quote("Attack on Titan", "Levi Ackerman", "The only thing we’re allowed to do is to believe."));
        quotes.add(new Quote("Death Note", "L", "I’m justice!"));

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("✨ Welcome to Anime Quote Explorer ✨");
        System.out.println("Random Quote: " + quotes.get(rand.nextInt(quotes.size())));

        while (true) {
            System.out.println("\nOptions: 1) Search by anime 2) Search by character 3) Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter anime name: ");
                String anime = sc.nextLine();
                quotes.stream()
                      .filter(q -> q.anime.equalsIgnoreCase(anime))
                      .forEach(System.out::println);
            } else if (choice == 2) {
                System.out.print("Enter character name: ");
                String character = sc.nextLine();
                quotes.stream()
                      .filter(q -> q.character.equalsIgnoreCase(character))
                      .forEach(System.out::println);
            } else {
                System.out.println("Goodbye, anime lover!");
                break;
            }
        }
        sc.close();
    }
}
