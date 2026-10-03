import java.util.*;

class Room {
    int roomNumber;
    boolean isBooked;
    String customerName;
    int days;
    double pricePerDay;

    Room(int roomNumber, double pricePerDay) {
        this.roomNumber = roomNumber;
        this.pricePerDay = pricePerDay;
        this.isBooked = false;
    }

    void bookRoom(String customerName, int days) {
        this.customerName = customerName;
        this.days = days;
        this.isBooked = true;
    }

    void freeRoom() {
        this.customerName = null;
        this.days = 0;
        this.isBooked = false;
    }

    double calculateBill() {
        return days * pricePerDay;
    }
}

public class HotelManagement {
    static Scanner sc = new Scanner(System.in);
    static List<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {
        // Initialize rooms
        for (int i = 1; i <= 5; i++) {
            rooms.add(new Room(i, 1000 + (i * 200))); // Different prices per room
        }

        while (true) {
            System.out.println("\n--- Hotel Management System ---");
            System.out.println("1. Book Room");
            System.out.println("2. Show Room Availability");
            System.out.println("3. Show Customer Records");
            System.out.println("4. Generate Bill");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> bookRoom();
                case 2 -> showAvailability();
                case 3 -> showRecords();
                case 4 -> generateBill();
                case 5 -> {
                    System.out.println("Exiting... Thank you!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void bookRoom() {
        System.out.print("Enter room number to book: ");
        int roomNo = sc.nextInt();
        Room room = rooms.get(roomNo - 1);

        if (room.isBooked) {
            System.out.println("Room already booked!");
        } else {
            System.out.print("Enter customer name: ");
            String name = sc.next();
            System.out.print("Enter number of days: ");
            int days = sc.nextInt();
            room.bookRoom(name, days);
            System.out.println("Room booked successfully!");
        }
    }

    static void showAvailability() {
        for (Room room : rooms) {
            System.out.println("Room " + room.roomNumber + " - " +
                    (room.isBooked ? "Booked" : "Available"));
        }
    }

    static void showRecords() {
        for (Room room : rooms) {
            if (room.isBooked) {
                System.out.println("Room " + room.roomNumber + " booked by " +
                        room.customerName + " for " + room.days + " days.");
            }
        }
    }

    static void generateBill() {
        System.out.print("Enter room number: ");
        int roomNo = sc.nextInt();
        Room room = rooms.get(roomNo - 1);

        if (room.isBooked) {
            System.out.println("Bill for " + room.customerName + ": ₹" + room.calculateBill());
            room.freeRoom(); // Free room after checkout
        } else {
            System.out.println("Room is not booked!");
        }
    }
}
