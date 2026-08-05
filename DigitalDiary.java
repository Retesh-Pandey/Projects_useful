import java.util.*;

class Diary {
    private List<String> entries = new ArrayList<>();

    public void addEntry(String entry) {
        entries.add(entry);
        System.out.println("Entry added!");
    }

    public void viewEntries() {
        if (entries.isEmpty()) {
            System.out.println("No entries yet.");
            return;
        }
        for (int i = 0; i < entries.size(); i++) {
            System.out.println((i+1) + ". " + entries.get(i));
        }
    }

    public void deleteEntry(int index) {
        if (index >= 0 && index < entries.size()) {
            entries.remove(index);
            System.out.println("Entry deleted!");
        } else {
            System.out.println("Invalid entry number.");
        }
    }
}

public class DigitalDiary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Diary diary = new Diary();

        while (true) {
            System.out.println("\n--- Digital Diary ---");
            System.out.println("1. Add Entry");
            System.out.println("2. View Entries");
            System.out.println("3. Delete Entry");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Write your entry: ");
                    String entry = sc.nextLine();
                    diary.addEntry(entry);
                    break;
                case 2:
                    diary.viewEntries();
                    break;
                case 3:
                    diary.viewEntries();
                    System.out.print("Enter entry number to delete: ");
                    int index = sc.nextInt() - 1;
                    diary.deleteEntry(index);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

