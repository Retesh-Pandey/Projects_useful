import java.util.*;

class Scene {
    private String title;
    private String description;
    private List<String> characters;

    public Scene(String title, String description) {
        this.title = title;
        this.description = description;
        this.characters = new ArrayList<>();
    }

    public void addCharacter(String character) {
        characters.add(character);
    }

    public void displayScene() {
        System.out.println("🎬 Scene: " + title);
        System.out.println("Description: " + description);
        System.out.println("Characters: " + characters);
        System.out.println("-----------------------------");
    }
}

public class FilmMakerApp {
    private static List<Scene> scenes = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Film Making Tool ---");
            System.out.println("1. Add Scene");
            System.out.println("2. Add Character to Scene");
            System.out.println("3. View All Scenes");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addScene();
                case 2 -> addCharacterToScene();
                case 3 -> viewScenes();
                case 4 -> {
                    System.out.println("Exiting Film Maker App...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void addScene() {
        System.out.print("Enter scene title: ");
        String title = sc.nextLine();
        System.out.print("Enter scene description: ");
        String desc = sc.nextLine();
        scenes.add(new Scene(title, desc));
        System.out.println("Scene added successfully!");
    }

    private static void addCharacterToScene() {
        if (scenes.isEmpty()) {
            System.out.println("No scenes available. Add a scene first!");
            return;
        }
        viewScenes();
        System.out.print("Select scene number: ");
        int index = sc.nextInt();
        sc.nextLine();
        if (index < 1 || index > scenes.size()) {
            System.out.println("Invalid scene number!");
            return;
        }
        System.out.print("Enter character name: ");
        String character = sc.nextLine();
        scenes.get(index - 1).addCharacter(character);
        System.out.println("Character added successfully!");
    }

    private static void viewScenes() {
        if (scenes.isEmpty()) {
            System.out.println("No scenes to display.");
            return;
        }
        for (int i = 0; i < scenes.size(); i++) {
            System.out.println("Scene #" + (i + 1));
            scenes.get(i).displayScene();
        }
    }
}
