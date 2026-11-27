import java.util.ArrayList;
import java.util.Scanner;

class Victim {
    String name;
    String city;
    String need;
    int priority;

    Victim(String name, String city, String need, int priority) {
        this.name = name;
        this.city = city;
        this.need = need;
        this.priority = priority;
    }
}

class Volunteer {
    String name;
    String city;
    String resource;

    Volunteer(String name, String city, String resource) {
        this.name = name;
        this.city = city;
        this.resource = resource;
    }
}

public class DisasterResourceMatcher {

    static ArrayList<Victim> victims = new ArrayList<>();
    static ArrayList<Volunteer> volunteers = new ArrayList<>();

    public static void addVictim(Scanner sc) {
        System.out.print("Victim Name: ");
        String name = sc.next();

        System.out.print("City: ");
        String city = sc.next();

        System.out.print("Need (Food/Medicine/Shelter/Blood): ");
        String need = sc.next();

        System.out.print("Priority (1-100): ");
        int priority = sc.nextInt();

        victims.add(new Victim(name, city, need, priority));

        System.out.println("Victim Registered Successfully!");
    }

    public static void addVolunteer(Scanner sc) {
        System.out.print("Volunteer Name: ");
        String name = sc.next();

        System.out.print("City: ");
        String city = sc.next();

        System.out.print("Resource Available: ");
        String resource = sc.next();

        volunteers.add(new Volunteer(name, city, resource));

        System.out.println("Volunteer Registered Successfully!");
    }

    public static void matchResources() {

        if(victims.isEmpty() || volunteers.isEmpty()) {
            System.out.println("Not enough data for matching.");
            return;
        }

        System.out.println("\n===== MATCH RESULTS =====");

        for(Victim v : victims) {

            Volunteer bestMatch = null;

            for(Volunteer vol : volunteers) {

                if(v.city.equalsIgnoreCase(vol.city) &&
                   v.need.equalsIgnoreCase(vol.resource)) {

                    bestMatch = vol;
                    break;
                }
            }

            if(bestMatch != null) {
                System.out.println("-------------------------");
                System.out.println("Victim     : " + v.name);
                System.out.println("Need       : " + v.need);
                System.out.println("Volunteer  : " + bestMatch.name);
                System.out.println("City       : " + v.city);
                System.out.println("Status     : MATCH FOUND");
            } else {
                System.out.println("-------------------------");
                System.out.println("Victim     : " + v.name);
                System.out.println("Need       : " + v.need);
                System.out.println("Status     : NO MATCH FOUND");
            }
        }
    }

    public static void generateReport() {

        System.out.println("\n===== DISASTER REPORT =====");
        System.out.println("Total Victims     : " + victims.size());
        System.out.println("Total Volunteers  : " + volunteers.size());

        int critical = 0;

        for(Victim v : victims) {
            if(v.priority >= 80) {
                critical++;
            }
        }

        System.out.println("Critical Cases    : " + critical);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true) {

            System.out.println("\n===== DISASTER RESOURCE MATCHER =====");
            System.out.println("1. Add Victim");
            System.out.println("2. Add Volunteer");
            System.out.println("3. Match Resources");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch(choice) {

                case 1:
                    addVictim(sc);
                    break;

                case 2:
                    addVolunteer(sc);
                    break;

                case 3:
                    matchResources();
                    break;

                case 4:
                    generateReport();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}