import java.util.*;

class VocabularyBuilder {
    private Map<String, String> words = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    public void addWord() {
        System.out.print("Enter new word: ");
        String word = sc.nextLine();
        System.out.print("Enter meaning: ");
        String meaning = sc.nextLine();
        words.put(word, meaning);
        System.out.println("Word added successfully!\n");
    }

    public void viewWords() {
        System.out.println("=== Vocabulary List ===");
        for (String word : words.keySet()) {
            System.out.println(word + " : " + words.get(word));
        }
        System.out.println();
    }

    public void quiz() {
        if (words.isEmpty()) {
            System.out.println("No words added yet!\n");
            return;
        }
        List<String> keys = new ArrayList<>(words.keySet());
        Collections.shuffle(keys);
        int score = 0;

        for (String word : keys) {
            System.out.println("What is the meaning of: " + word);
            String ans = sc.nextLine();
            if (ans.equalsIgnoreCase(words.get(word))) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! Correct meaning: " + words.get(word) + "\n");
            }
        }
        System.out.println("Quiz finished! Score: " + score + "/" + keys.size() + "\n");
    }

    public void menu() {
        while (true) {
            System.out.println("=== Vocabulary Builder Menu ===");
            System.out.println("1. Add Word");
            System.out.println("2. View Words");
            System.out.println("3. Take Quiz");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: addWord(); break;
                case 2: viewWords(); break;
                case 3: quiz(); break;
                case 4: System.out.println("Keep learning new words!"); return;
                default: System.out.println("Invalid choice!\n");
            }
        }
    }

    public static void main(String[] args) {
        new VocabularyBuilder().menu();
    }
}
