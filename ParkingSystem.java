import java.util.*;

class Vehicle {
    private String plateNumber;
    private long entryTime;
    private long exitTime;

    public Vehicle(String plateNumber) {
        this.plateNumber = plateNumber;
        this.entryTime = System.currentTimeMillis(); // record entry
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void exit() {
        this.exitTime = System.currentTimeMillis(); // record exit
    }

    public long getStayDurationMinutes() {
        if (exitTime == 0) return 0;
        return (exitTime - entryTime) / (1000 * 60); // convert ms → minutes
    }

    public double calculateFare(double ratePerMinute) {
        return getStayDurationMinutes() * ratePerMinute;
    }
}

public class ParkingSystem {
    private Map<String, Vehicle> activeVehicles = new HashMap<>();
    private double ratePerMinute;

    public ParkingSystem(double ratePerMinute) {
        this.ratePerMinute = ratePerMinute;
    }

    public void vehicleEntry(String plateNumber) {
        if (activeVehicles.containsKey(plateNumber)) {
            System.out.println("Vehicle already inside!");
        } else {
            Vehicle v = new Vehicle(plateNumber);
            activeVehicles.put(plateNumber, v);
            System.out.println("Vehicle " + plateNumber + " entered at " + new Date(v.entryTime));
        }
    }

    public void vehicleExit(String plateNumber) {
        Vehicle v = activeVehicles.get(plateNumber);
        if (v == null) {
            System.out.println("Vehicle not found!");
            return;
        }
        v.exit();
        long stay = v.getStayDurationMinutes();
        double fare = v.calculateFare(ratePerMinute);
        System.out.println("Vehicle " + plateNumber + " exited at " + new Date(v.exitTime));
        System.out.println("Stay time: " + stay + " minutes");
        System.out.println("Fare: ₹" + fare);
        activeVehicles.remove(plateNumber);
    }

    public static void main(String[] args) throws InterruptedException {
        ParkingSystem ps = new ParkingSystem(2.0); // ₹2 per minute

        ps.vehicleEntry("UP32AB1234");

        // Simulate waiting
        Thread.sleep(5000); // 5 seconds

        ps.vehicleExit("UP32AB1234");
    }
}
