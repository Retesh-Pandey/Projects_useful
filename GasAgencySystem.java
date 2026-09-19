import java.util.*;

class GasBooking {
    private static int bookingCounter = 1000;
    private int bookingId;
    private String customerName;
    private String address;
    private boolean delivered;

    public GasBooking(String customerName, String address) {
        this.bookingId = ++bookingCounter;
        this.customerName = customerName;
        this.address = address;
        this.delivered = false;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() {
        return address;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void markDelivered() {
        this.delivered = true;
    }

    @Override
    public String toString() {
        return "BookingID: " + bookingId +
               ", Customer: " + customerName +
               ", Address: " + address +
               ", Status: " + (delivered ? "Delivered" : "Pending");
    }
}

public class GasAgencySystem {
    private static List<GasBooking> bookings = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Gas Agency Supply System ---");
            System.out.println("1. Book Cylinder");
            System.out.println("2. View All Bookings");
            System.out.println("3. Mark Delivery");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> bookCylinder();
                case 2 -> viewBookings();
                case 3 -> markDelivery();
                case 4 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }

    private static void bookCylinder() {
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();

        GasBooking booking = new GasBooking(name, address);
        bookings.add(booking);
        System.out.println("Cylinder booked successfully! Booking ID: " + booking.getBookingId());
    }

    private static void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            for (GasBooking b : bookings) {
                System.out.println(b);
            }
        }
    }

    private static void markDelivery() {
        System.out.print("Enter Booking ID to mark delivered: ");
        int id = sc.nextInt();
        boolean found = false;

        for (GasBooking b : bookings) {
            if (b.getBookingId() == id) {
                b.markDelivered();
                System.out.println("Booking ID " + id + " marked as delivered.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Booking ID not found.");
        }
    }
}
