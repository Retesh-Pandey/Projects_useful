import java.util.*;

class Song {
    String title;
    String artist;
    String genre;

    Song(String title, String artist, String genre) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + artist + " [" + genre + "]";
    }
}

public class MusicPlaylist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Song> playlist = new ArrayList<>();

        while (true) {
            System.out.println("\n🎶 Music Playlist Menu 🎶");
            System.out.println("1. Add Song");
            System.out.println("2. View Playlist");
            System.out.println("3. Search by Genre");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter song title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter artist name: ");
                    String artist = sc.nextLine();
                    System.out.print("Enter genre (Bollywood, Pop, Classical, etc.): ");
                    String genre = sc.nextLine();
                    playlist.add(new Song(title, artist, genre));
                    System.out.println("✅ Song added!");
                    break;

                case 2:
                    System.out.println("\n📀 Your Playlist:");
                    if (playlist.isEmpty()) {
                        System.out.println("No songs yet!");
                    } else {
                        for (Song s : playlist) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter genre to search: ");
                    String searchGenre = sc.nextLine();
                    System.out.println("\n🎧 Songs in " + searchGenre + ":");
                    boolean found = false;
                    for (Song s : playlist) {
                        if (s.genre.equalsIgnoreCase(searchGenre)) {
                            System.out.println(s);
                            found = true;
                        }
                    }
                    if (!found) System.out.println("No songs found in this genre.");
                    break;

                case 4:
                    System.out.println("Goodbye! Keep enjoying your music 🎵");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again!");
            }
        }
    }
}
