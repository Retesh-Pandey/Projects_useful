import java.util.*;

class Flight {
    String flightNumber;
    String destination;
    int capacity;
    List<String> passengers;

    Flight(String flightNumber, String destination, int capacity) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.capacity = capacity;
        this.passengers = new ArrayList<>();
    }

    boolean bookSeat(String passengerName) {
        if (passengers.size() < capacity) {
            passengers.add(passengerName);
            System.out.println("Booking confirmed for " + passengerName + " on flight " + flightNumber);
            return true;
        } else {
            System.out.println("Sorry, flight " + flightNumber + " is full.");
            return false;
        }
    }

    void showDetails() {
        System.out.println("Flight: " + flightNumber + " | Destination: " + destination + " | Seats left: " + (capacity - passengers.size()));
    }
}

public class AirlineSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Flight flight1 = new Flight("AI101", "Delhi", 3);
        Flight flight2 = new Flight("AI202", "Mumbai", 2);

        Map<String, Flight> flights = new HashMap<>();
        flights.put(flight1.flightNumber, flight1);
        flights.put(flight2.flightNumber, flight2);

        while (true) {
            System.out.println("\n--- Airline Reservation Menu ---");
            System.out.println("1. View Flights");
            System.out.println("2. Book a Seat");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                for (Flight f : flights.values()) {
                    f.showDetails();
                }
            } else if (choice == 2) {
                System.out.print("Enter flight number: ");
                String fno = sc.nextLine();
                Flight selected = flights.get(fno);
                if (selected != null) {
                    System.out.print("Enter passenger name: ");
                    String name = sc.nextLine();
                    selected.bookSeat(name);
                } else {
                    System.out.println("Flight not found.");
                }
            } else if (choice == 3) {
                System.out.println("Thank you for using Airline System!");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
