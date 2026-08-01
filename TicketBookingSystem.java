import java.util.*;

class Ticket {
    int ticketId;
    String passengerName;
    String destination;
    boolean booked;

    Ticket(int ticketId, String passengerName, String destination) {
        this.ticketId = ticketId;
        this.passengerName = passengerName;
        this.destination = destination;
        this.booked = true;
    }

    void display() {
        System.out.println("Ticket ID: " + ticketId +
                           ", Passenger: " + passengerName +
                           ", Destination: " + destination +
                           ", Status: " + (booked ? "Booked" : "Cancelled"));
    }
}

public class TicketBookingSystem {
    static Map<Integer, Ticket> tickets = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    // Handle user queries
    static void handleQuery(String query) {
        query = query.toLowerCase();

        if (query.contains("book")) {
            bookTicket();
        } else if (query.contains("display") || query.contains("show")) {
            displayTickets();
        } else if (query.contains("search")) {
            searchTicket();
        } else if (query.contains("cancel")) {
            cancelTicket();
        } else {
            System.out.println("❌ Sorry, I didn’t understand that query.\n");
        }
    }

    static void bookTicket() {
        System.out.print("Enter Ticket ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        if (tickets.containsKey(id)) {
            System.out.println("Ticket ID already exists!\n");
            return;
        }
        System.out.print("Enter Passenger Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Destination: ");
        String dest = sc.nextLine();

        tickets.put(id, new Ticket(id, name, dest));
        System.out.println("✅ Ticket booked successfully!\n");
    }

    static void displayTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No tickets booked.\n");
            return;
        }
        System.out.println("=== Ticket List ===");
        for (Ticket t : tickets.values()) {
            t.display();
        }
        System.out.println();
    }

    static void searchTicket() {
        System.out.print("Enter Ticket ID to search: ");
        int id = sc.nextInt();
        if (tickets.containsKey(id)) {
            tickets.get(id).display();
        } else {
            System.out.println("Ticket not found.\n");
        }
    }

    static void cancelTicket() {
        System.out.print("Enter Ticket ID to cancel: ");
        int id = sc.nextInt();
        if (tickets.containsKey(id)) {
            Ticket t = tickets.get(id);
            if (t.booked) {
                t.booked = false;
                System.out.println("✅ Ticket cancelled successfully!\n");
            } else {
                System.out.println("Ticket already cancelled.\n");
            }
        } else {
            System.out.println("Ticket not found.\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Ticket Booking Query System ===");
        String query;
        do {
            System.out.print("Enter your query (book/search/display/cancel/exit): ");
            query = sc.nextLine();
            if (!query.equalsIgnoreCase("exit")) {
                handleQuery(query);
            }
        } while (!query.equalsIgnoreCase("exit"));

        System.out.println("👋 Exiting system. Goodbye!");
    }
}
