import java.util.*;

class NGO {
    String name;
    String contact;
    String mission;

    NGO(String name, String contact, String mission) {
        this.name = name;
        this.contact = contact;
        this.mission = mission;
    }

    @Override
    public String toString() {
        return "NGO Name: " + name + "\nContact: " + contact + "\nMission: " + mission;
    }
}

public class NGOConnector {
    static Scanner sc = new Scanner(System.in);
    static List<NGO> ngoList = new ArrayList<>();
    static Map<String, List<String>> messages = new HashMap<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- NGO Connector ---");
            System.out.println("1. Register NGO");
            System.out.println("2. View NGOs");
            System.out.println("3. Send Message");
            System.out.println("4. View Messages");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> registerNGO();
                case 2 -> viewNGOs();
                case 3 -> sendMessage();
                case 4 -> viewMessages();
                case 5 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    static void registerNGO() {
        System.out.print("Enter NGO name: ");
        String name = sc.nextLine();
        System.out.print("Enter contact info: ");
        String contact = sc.nextLine();
        System.out.print("Enter mission statement: ");
        String mission = sc.nextLine();

        ngoList.add(new NGO(name, contact, mission));
        System.out.println("NGO registered successfully!");
    }

    static void viewNGOs() {
        if (ngoList.isEmpty()) {
            System.out.println("No NGOs registered yet.");
            return;
        }
        for (int i = 0; i < ngoList.size(); i++) {
            System.out.println("\n--- NGO " + (i + 1) + " ---");
            System.out.println(ngoList.get(i));
        }
    }

    static void sendMessage() {
        if (ngoList.isEmpty()) {
            System.out.println("No NGOs available to message.");
            return;
        }
        System.out.print("Enter your NGO name: ");
        String sender = sc.nextLine();
        System.out.print("Enter recipient NGO name: ");
        String recipient = sc.nextLine();
        System.out.print("Enter message: ");
        String msg = sc.nextLine();

        messages.putIfAbsent(recipient, new ArrayList<>());
        messages.get(recipient).add("From " + sender + ": " + msg);
        System.out.println("Message sent!");
    }

    static void viewMessages() {
        System.out.print("Enter your NGO name to view messages: ");
        String ngoName = sc.nextLine();

        if (!messages.containsKey(ngoName) || messages.get(ngoName).isEmpty()) {
            System.out.println("No messages for " + ngoName);
            return;
        }
        System.out.println("\n--- Messages for " + ngoName + " ---");
        for (String msg : messages.get(ngoName)) {
            System.out.println(msg);
        }
    }
}
