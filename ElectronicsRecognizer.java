import java.util.*;

class Electronic {
    String name;
    String type;
    Map<String, String> specs;

    Electronic(String name, String type, Map<String, String> specs) {
        this.name = name;
        this.type = type;
        this.specs = specs;
    }

    @Override
    public String toString() {
        return name + " (" + type + ") " + specs;
    }
}

public class ElectronicsRecognizer {
    private static List<Electronic> database = new ArrayList<>();

    // Add sample electronics
    static {
        database.add(new Electronic("Dell Inspiron", "Laptop",
                Map.of("RAM", "8GB", "Storage", "512GB SSD", "Processor", "Intel i5")));
        database.add(new Electronic("Samsung Galaxy S22", "Smartphone",
                Map.of("RAM", "8GB", "Storage", "128GB", "Processor", "Snapdragon 8 Gen1")));
        database.add(new Electronic("Sony Bravia", "Television",
                Map.of("ScreenSize", "55 inch", "Resolution", "4K", "Type", "LED")));
    }

    public static String recognize(Map<String, String> inputSpecs) {
        for (Electronic e : database) {
            int matchCount = 0;
            for (String key : inputSpecs.keySet()) {
                if (e.specs.containsKey(key) && e.specs.get(key).equalsIgnoreCase(inputSpecs.get(key))) {
                    matchCount++;
                }
            }
            if (matchCount >= 2) { // at least 2 specs match
                return "Recognized as: " + e;
            }
        }
        return "No matching electronic found.";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> inputSpecs = new HashMap<>();

        System.out.println("Enter specifications to recognize an electronic device.");
        System.out.print("RAM: ");
        inputSpecs.put("RAM", sc.nextLine());
        System.out.print("Storage: ");
        inputSpecs.put("Storage", sc.nextLine());
        System.out.print("Processor: ");
        inputSpecs.put("Processor", sc.nextLine());

        String result = recognize(inputSpecs);
        System.out.println(result);
    }
}
