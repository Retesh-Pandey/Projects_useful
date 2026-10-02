import java.util.*;

class Pothole {
    private String location;
    private int severity; // 1 = minor, 2 = moderate, 3 = severe

    public Pothole(String location, int severity) {
        this.location = location;
        this.severity = severity;
    }

    public String getLocation() { return location; }
    public int getSeverity() { return severity; }

    @Override
    public String toString() {
        return "Pothole at " + location + " | Severity: " + severity;
    }
}

class PotholeDetector {
    private List<Pothole> potholes = new ArrayList<>();

    public void detect(String location, int vibrationLevel) {
        int severity = classifySeverity(vibrationLevel);
        if (severity > 0) {
            Pothole p = new Pothole(location, severity);
            potholes.add(p);
            System.out.println("Detected: " + p);
        }
    }

    private int classifySeverity(int vibrationLevel) {
        if (vibrationLevel > 80) return 3; // severe
        else if (vibrationLevel > 50) return 2; // moderate
        else if (vibrationLevel > 30) return 1; // minor
        return 0; // no pothole
    }

    public void generateReport() {
        System.out.println("\n--- Pothole Report ---");
        for (Pothole p : potholes) {
            System.out.println(p);
        }
    }
}

public class SmartPotholeSystem {
    public static void main(String[] args) {
        PotholeDetector detector = new PotholeDetector();

        // Simulated vibration data
        detector.detect("Highway-21", 85);
        detector.detect("City Road-5", 40);
        detector.detect("Village Road-2", 20);

        detector.generateReport();
    }
}
