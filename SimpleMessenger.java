import java.util.ArrayList;
import java.util.Scanner;

class Message {
    String sender;
    String content;

    Message(String sender, String content) {
        this.sender = sender;
        this.content = content;
    }

    @Override
    public String toString() {
        return sender + ": " + content;
    }
}

public class SimpleMessenger {
    private static ArrayList<Message> chatHistory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Simple Messenger!");
        System.out.print("Enter User1 name: ");
        String user1 = sc.nextLine();
        System.out.print("Enter User2 name: ");
        String user2 = sc.nextLine();

        boolean running = true;
        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. " + user1 + " send message");
            System.out.println("2. " + user2 + " send message");
            System.out.println("3. View chat history");
            System.out.println("4. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print(user1 + " type message: ");
                    String msg1 = sc.nextLine();
                    chatHistory.add(new Message(user1, msg1));
                    break;
                case 2:
                    System.out.print(user2 + " type message: ");
                    String msg2 = sc.nextLine();
                    chatHistory.add(new Message(user2, msg2));
                    break;
                case 3:
                    System.out.println("\n--- Chat History ---");
                    for (Message m : chatHistory) {
                        System.out.println(m);
                    }
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting messenger...");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
        sc.close();
    }
}
