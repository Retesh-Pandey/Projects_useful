import java.util.*;

class Appointment {
    int id;
    String patientName;
    String doctorName;
    String date;
    String status;

    Appointment(int id, String patientName, String doctorName, String date) {
        this.id = id;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = date;
        this.status = "Scheduled";
    }

    void complete() {
        this.status = "Completed";
    }

    @Override
    public String toString() {
        return "Appointment ID: " + id +
               "\nPatient: " + patientName +
               "\nDoctor: " + doctorName +
               "\nDate: " + date +
               "\nStatus: " + status + "\n";
    }
}

public class HealthcareSystem {
    static Scanner sc = new Scanner(System.in);
    static List<Appointment> appointments = new ArrayList<>();
    static int appointmentCounter = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Healthcare Appointment System ---");
            System.out.println("1. Book Appointment");
            System.out.println("2. View Appointments");
            System.out.println("3. Complete Appointment");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> bookAppointment();
                case 2 -> viewAppointments();
                case 3 -> completeAppointment();
                case 4 -> {
                    System.out.println("Exiting system...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void bookAppointment() {
        System.out.print("Enter patient name: ");
        String patient = sc.nextLine();
        System.out.print("Enter doctor name: ");
        String doctor = sc.nextLine();
        System.out.print("Enter date (dd-mm-yyyy): ");
        String date = sc.nextLine();

        Appointment a = new Appointment(appointmentCounter++, patient, doctor, date);
        appointments.add(a);
        System.out.println("Appointment booked successfully!");
    }

    static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
        } else {
            for (Appointment a : appointments) {
                System.out.println(a);
            }
        }
    }

    static void completeAppointment() {
        System.out.print("Enter Appointment ID to complete: ");
        int id = sc.nextInt();
        for (Appointment a : appointments) {
            if (a.id == id) {
                a.complete();
                System.out.println("Appointment marked as completed!");
                return;
            }
        }
        System.out.println("Appointment ID not found.");
    }
}
