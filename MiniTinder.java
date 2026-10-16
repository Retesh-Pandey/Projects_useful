import java.util.*;

public class MiniTinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sample profiles
        String[] names = {"Aditi, 22, Loves music", 
                          "Rahul, 25, Cricket fan", 
                          "Sneha, 23, Bookworm", 
                          "Arjun, 24, Traveller"};

        List<String> likedProfiles = new ArrayList<>();

        System.out.println("Welcome to Mini Tinder!");
        System.out.println("Type 'l' to Like, 's' to Skip.\n");

        for (String profile : names) {
            System.out.println("Profile: " + profile);
            System.out.print("Your choice (l/s): ");
            String choice = sc.nextLine().trim().toLowerCase();

            if (choice.equals("l")) {
                likedProfiles.add(profile);
                System.out.println("You liked this profile!\n");
            } else {
                System.out.println("You skipped.\n");
            }
        }

        System.out.println("=== Your Liked Profiles ===");
        for (String liked : likedProfiles) {
            System.out.println(liked);
        }

        System.out.println("Thanks for using Mini Tinder!");
        sc.close();
    }
}
