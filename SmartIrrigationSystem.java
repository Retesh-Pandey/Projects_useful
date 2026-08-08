import java.util.*;

public class SmartIrrigationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crop water requirements (liters per day per plant)
        Map<String, Integer> cropWaterNeeds = new HashMap<>();
        cropWaterNeeds.put("wheat", 3);
        cropWaterNeeds.put("rice", 5);
        cropWaterNeeds.put("maize", 4);
        cropWaterNeeds.put("sugarcane", 6);

        System.out.println("🌱 Welcome to Smart Irrigation System 🌱");
        System.out.print("Enter crop type (wheat/rice/maize/sugarcane): ");
        String crop = sc.nextLine().toLowerCase();

        System.out.print("Enter soil moisture level (0-100): ");
        int moisture = sc.nextInt();

        System.out.print("Is rain predicted today? (true/false): ");
        boolean rain = sc.nextBoolean();

        if (!cropWaterNeeds.containsKey(crop)) {
            System.out.println("⚠️ Crop not found in database. Please add it first.");
            return;
        }

        int waterNeed = cropWaterNeeds.get(crop);

        System.out.println("\n📊 Irrigation Report:");
        if (moisture < 40 && !rain) {
            System.out.println("✅ Irrigation needed. Supply " + waterNeed + " liters per plant.");
        } else if (rain) {
            System.out.println("🌧️ Rain predicted. No irrigation required today.");
        } else {
            System.out.println("💧 Soil moisture is sufficient. No irrigation required.");
        }

        sc.close();
    }
}
