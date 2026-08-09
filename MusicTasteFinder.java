import java.util.Scanner;

public class MusicTasteFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🎵 Welcome to Indian Music Taste Finder 🎵");
        System.out.println("Answer a few questions to discover your favorite music style!\n");

        // Question 1: Language preference
        System.out.println("1. Which language do you prefer for songs?");
        System.out.println("   a) Hindi\n   b) Punjabi\n   c) Tamil/Telugu\n   d) English");
        String language = sc.nextLine().toLowerCase();

        // Question 2: Mood preference
        System.out.println("\n2. What mood do you usually enjoy?");
        System.out.println("   a) Romantic\n   b) Energetic/Dance\n   c) Devotional\n   d) Chill/Relax");
        String mood = sc.nextLine().toLowerCase();

        // Question 3: Instrument preference
        System.out.println("\n3. Which instrument sound attracts you most?");
        System.out.println("   a) Guitar\n   b) Tabla/Dhol\n   c) Flute/Sitar\n   d) Electronic beats");
        String instrument = sc.nextLine().toLowerCase();

        // Question 4: Artist preference
        System.out.println("\n4. Which type of artist do you like?");
        System.out.println("   a) Bollywood playback singers (Arijit Singh, Shreya Ghoshal)");
        System.out.println("   b) Punjabi stars (Diljit Dosanjh, Sidhu Moose Wala)");
        System.out.println("   c) Classical legends (Lata Mangeshkar, A.R. Rahman)");
        System.out.println("   d) Indie/Pop (Prateek Kuhad, Ritviz)");
        String artist = sc.nextLine().toLowerCase();

        // Simple logic to suggest music taste
        System.out.println("\n✨ Based on your answers, we suggest: ✨");

        if(language.contains("hindi") && mood.contains("romantic")) {
            System.out.println("🎶 Bollywood Romantic Songs (Arijit Singh, Shreya Ghoshal)");
        } else if(language.contains("punjabi") || instrument.contains("dhol")) {
            System.out.println("🎶 Punjabi Pop & Bhangra (Diljit Dosanjh, Sidhu Moose Wala)");
        } else if(mood.contains("devotional") || instrument.contains("flute")) {
            System.out.println("🎶 Indian Classical & Bhajans (Lata Mangeshkar, Hariharan)");
        } else if(language.contains("english") || artist.contains("indie")) {
            System.out.println("🎶 Indie/Pop Fusion (Prateek Kuhad, Ritviz)");
        } else {
            System.out.println("🎶 A mix of Bollywood & Regional hits!");
        }

        System.out.println("\nThanks for playing! Explore your music taste today 🎵");
        sc.close();
    }
}
