import java.util.*;

class Field {
    String name;
    int moistureLevel; // 0–100
    boolean rainPredicted;

    Field(String name, int moistureLevel, boolean rainPredicted) {
        this.name = name;
        this.moistureLevel = moistureLevel;
        this.rainPredicted = rainPredicted;
    }

    public boolean needsIrrigation() {
        return moistureLevel < 40 && !rainPredicted;
    }
}

public class SmartIrrigationScheduler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Field> fields = new ArrayList<>();

        System.out.println("🌱 Smart Irrigation Scheduler 🌱");
        System.out.print("Enter number of fields: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nField " + (i + 1) + ":");
            System.out.print("Enter field name: ");
            String name = sc.nextLine();

            System.out.print("Enter soil moisture (0-100): ");
            int moisture = sc.nextInt();

            System.out.print("Is rain predicted? (true/false): ");
            boolean rain = sc.nextBoolean();
            sc.nextLine(); // consume newline

            fields.add(new Field(name, moisture, rain));
        }

        System.out.println("\n📊 Irrigation Schedule:");
        for (Field f : fields) {
            if (f.needsIrrigation()) {
                System.out.println("✅ Irrigate field '" + f.name + "' today.");
            } else if (f.rainPredicted) {
                System.out.println("🌧️ Skip irrigation for '" + f.name + "' (rain expected).");
            } else {
                System.out.println("💧 Field '" + f.name + "' has sufficient moisture.");
            }
        }

        sc.close();
    }
}
