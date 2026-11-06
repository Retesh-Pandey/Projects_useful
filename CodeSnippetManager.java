import java.util.ArrayList;
import java.util.Scanner;

class Snippet {
    String title;
    String code;

    Snippet(String title, String code) {
        this.title = title;
        this.code = code;
    }
}

public class CodeSnippetManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Snippet> snippets = new ArrayList<>();

        while (true) {
            System.out.println("\n=== Code Snippet Manager ===");
            System.out.println("1. Add Snippet");
            System.out.println("2. View Snippets");
            System.out.println("3. Search Snippet");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter code: ");
                    String code = sc.nextLine();

                    snippets.add(new Snippet(title, code));
                    System.out.println("Snippet Saved!");
                    break;

                case 2:
                    if (snippets.isEmpty()) {
                        System.out.println("No snippets found.");
                    } else {
                        for (Snippet s : snippets) {
                            System.out.println("\nTitle: " + s.title);
                            System.out.println("Code: " + s.code);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter title to search: ");
                    String search = sc.nextLine();

                    boolean found = false;
                    for (Snippet s : snippets) {
                        if (s.title.equalsIgnoreCase(search)) {
                            System.out.println("Code: " + s.code);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Snippet not found.");
                    }
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}