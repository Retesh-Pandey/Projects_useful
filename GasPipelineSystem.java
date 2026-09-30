import java.util.*;

class Pipeline {
    String source;
    String destination;
    double capacity;   // in cubic meters per hour
    double currentFlow;

    Pipeline(String source, String destination, double capacity) {
        this.source = source;
        this.destination = destination;
        this.capacity = capacity;
        this.currentFlow = 0;
    }

    void transportGas(double amount) {
        if (amount <= capacity) {
            currentFlow = amount;
            System.out.println("Transporting " + amount + " m³/hr from " 
                               + source + " to " + destination);
        } else {
            System.out.println("⚠ Flow exceeds capacity! Leakage risk detected.");
        }
    }

    void checkStatus() {
        if (currentFlow == 0) {
            System.out.println("Pipeline " + source + " → " + destination + " is idle.");
        } else if (currentFlow > capacity) {
            System.out.println("⚠ Overload detected in pipeline " + source + " → " + destination);
        } else {
            System.out.println("Pipeline " + source + " → " + destination 
                               + " is operating normally at " + currentFlow + " m³/hr.");
        }
    }
}

public class GasPipelineSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create sample pipelines
        Pipeline p1 = new Pipeline("CityA", "CityB", 1000);
        Pipeline p2 = new Pipeline("CityB", "CityC", 800);

        while (true) {
            System.out.println("\n--- Gas Pipeline Monitoring ---");
            System.out.println("1. Transport Gas");
            System.out.println("2. Check Pipeline Status");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter pipeline (1 or 2): ");
                    int pipeChoice = sc.nextInt();
                    System.out.print("Enter gas flow amount (m³/hr): ");
                    double amount = sc.nextDouble();

                    if (pipeChoice == 1) p1.transportGas(amount);
                    else if (pipeChoice == 2) p2.transportGas(amount);
                    else System.out.println("Invalid pipeline choice.");
                    break;

                case 2:
                    p1.checkStatus();
                    p2.checkStatus();
                    break;

                case 3:
                    System.out.println("Exiting system...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
