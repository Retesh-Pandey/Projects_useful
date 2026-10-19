import java.util.*;

class WarehouseDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input number of items
        System.out.print("Enter number of timber items in warehouse: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        // Step 2: Input item names
        String[] items = new String[n];
        System.out.println("Enter the names of timber items:");
        for (int i = 0; i < n; i++) {
            items[i] = sc.nextLine().trim();
        }

        // Step 3: Use HashMap to count occurrences
        Map<String, Integer> itemCount = new HashMap<>();
        for (String item : items) {
            itemCount.put(item, itemCount.getOrDefault(item, 0) + 1);
        }

        // Step 4: Print duplicates
        System.out.println("\nDuplicate timber items in warehouse:");
        boolean foundDuplicate = false;
        for (Map.Entry<String, Integer> entry : itemCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " (count: " + entry.getValue() + ")");
                foundDuplicate = true;
            }
        }

        if (!foundDuplicate) {
            System.out.println("No duplicates found.");
        }
    }
}
