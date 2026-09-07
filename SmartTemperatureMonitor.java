import java.util.Random;

public class SmartTemperatureMonitor {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();

        // Thresholds for IoT actions
        final int HIGH_TEMP = 30; // Celsius
        final int LOW_TEMP = 15;

        System.out.println("Starting Smart Home Temperature Monitor...");

        // Simulate continuous sensor readings
        for (int i = 1; i <= 20; i++) {
            int temp = 10 + random.nextInt(25); // random temp between 10–35
            System.out.println("Sensor Reading " + i + ": " + temp + "°C");

            // IoT logic
            if (temp > HIGH_TEMP) {
                System.out.println("⚠️ ALERT: Too hot! Turning ON cooling system.");
            } else if (temp < LOW_TEMP) {
                System.out.println("❄️ ALERT: Too cold! Turning ON heating system.");
            } else {
                System.out.println("✅ Temperature is normal. Systems OFF.");
            }

            Thread.sleep(1000); // simulate delay between readings
        }

        System.out.println("Monitoring stopped.");
    }
}
