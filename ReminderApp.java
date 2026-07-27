import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// Represents each household item
class FoodItem {
    private String name;
    private String manufactureDate;
    private String expiryDate;

    public FoodItem(String name, String manufactureDate, String expiryDate) {
        this.name = name;
        this.manufactureDate = manufactureDate;
        this.expiryDate = expiryDate;
    }

    public String getName() { return name; }
    public String getManufactureDate() { return manufactureDate; }
    public String getExpiryDate() { return expiryDate; }
}

// Simulated OCR utility
class OCRUtil {
    public static String extractTextFromImage(File imageFile) {
        // In real app: use Tesseract OCR or Google ML Kit
        // Here we simulate OCR output
        return "MFG: 12/07/2026 EXP: 12/08/2026";
    }

    public static FoodItem parseFoodItem(String rawText) {
        // Simple parsing logic (replace with regex in real app)
        String manufacture = "12/07/2026";
        String expiry = "12/08/2026";
        return new FoodItem("Milk Packet", manufacture, expiry);
    }
}

// Manages reminders
class ReminderManager {
    public static void scheduleReminder(FoodItem item) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate expiry = LocalDate.parse(item.getExpiryDate(), formatter);
        LocalDate reminderDate = expiry.minusDays(7);

        System.out.println("Reminder set for " + item.getName() +
                " on " + reminderDate.toString());
    }
}

// Simple database simulation
class DatabaseHelper {
    private List<FoodItem> items = new ArrayList<>();

    public void addItem(FoodItem item) {
        items.add(item);
        System.out.println("Item saved: " + item.getName());
    }

    public List<FoodItem> getAllItems() {
        return items;
    }
}

// Main workflow
public class ReminderApp {
    public static void main(String[] args) {
        // Step 1: Simulate user clicking picture
        String rawText = OCRUtil.extractTextFromImage(new File("milk.jpg"));

        // Step 2: Parse text into FoodItem
        FoodItem item = OCRUtil.parseFoodItem(rawText);

        // Step 3: Save to database
        DatabaseHelper db = new DatabaseHelper();
        db.addItem(item);

        // Step 4: Schedule reminder
        ReminderManager.scheduleReminder(item);

        // Step 5: Show all items
        System.out.println("Items in database:");
        for (FoodItem f : db.getAllItems()) {
            System.out.println("- " + f.getName() + " | Exp: " + f.getExpiryDate());
        }
    }
}
