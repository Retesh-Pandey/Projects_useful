import java.util.Scanner;

public class ConcertBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🎤 Welcome to Indian Concert Booking 🎤");
        System.out.println("Choose your city: ");
        System.out.println("1. Delhi\n2. Mumbai\n3. Bangalore\n4. Hyderabad");
        int city = sc.nextInt();

        System.out.println("\nChoose your artist: ");
        System.out.println("1. Arijit Singh\n2. Sidhu Moose Wala Tribute\n3. A.R. Rahman\n4. Prateek Kuhad");
        int artist = sc.nextInt();

        System.out.println("\nEnter number of tickets: ");
        int tickets = sc.nextInt();

        int pricePerTicket = 0;
        switch(artist) {
            case 1: pricePerTicket = 1500; break;
            case 2: pricePerTicket = 1200; break;
            case 3: pricePerTicket = 2000; break;
            case 4: pricePerTicket = 1000; break;
            default: System.out.println("Invalid choice!"); return;
        }

        int total = tickets * pricePerTicket;
        System.out.println("\n✅ Booking Confirmed!");
        System.out.println("City: " + city + " | Artist: " + artist);
        System.out.println("Tickets: " + tickets + " | Total Price: ₹" + total);

        System.out.println("Enjoy the concert 🎶");
        sc.close();
    }
}
