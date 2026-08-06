import java.util.*;

class ParkingLot {
    private Map<Integer, Boolean> slots;

    public ParkingLot(int size) {
        slots = new HashMap<>();
        for (int i = 1; i <= size; i++) {
            slots.put(i, true); // true = available
        }
    }

    public int assignSlot(String vehicleType) {
        for (int slot : slots.keySet()) {
            if (slots.get(slot)) {
                if (vehicleType.equals("EMERGENCY")) {
                    System.out.println("Emergency vehicle assigned to slot " + slot);
                } else {
                    System.out.println("Vehicle assigned to slot " + slot);
                }
                slots.put(slot, false);
                return slot;
            }
        }
        System.out.println("No slots available!");
        return -1;
    }

    public void freeSlot(int slot) {
        if (slots.containsKey(slot)) {
            slots.put(slot, true);
            System.out.println("Slot " + slot + " is now free.");
        }
    }
}

public class SmartParkingSystem {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(5);

        lot.assignSlot("NORMAL");
        lot.assignSlot("EMERGENCY");
        lot.assignSlot("NORMAL");

        lot.freeSlot(2);
        lot.assignSlot("NORMAL");
    }
}
