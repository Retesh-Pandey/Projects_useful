import java.util.Scanner;

class BiomedicalWasteManager {

    public static void classifyWaste(int choice) {

        switch (choice) {

            case 1:
                System.out.println("\nWaste Type: Human Anatomical Waste");
                System.out.println("Disposal: Incineration or Deep Burial");
                break;

            case 2:
                System.out.println("\nWaste Type: Sharps (Needles, Blades)");
                System.out.println("Disposal: Autoclaving and Shredding");
                break;

            case 3:
                System.out.println("\nWaste Type: Expired Medicines");
                System.out.println("Disposal: Return to Manufacturer or Incineration");
                break;

            case 4:
                System.out.println("\nWaste Type: Contaminated Plastic Waste");
                System.out.println("Disposal: Autoclaving and Recycling");
                break;

            case 5:
                System.out.println("\nWaste Type: Glassware");
                System.out.println("Disposal: Disinfection and Recycling");
                break;

            case 6:
                System.out.println("\nWaste Type: Chemical Waste");
                System.out.println("Disposal: Chemical Treatment and Secure Landfill");
                break;

            default:
                System.out.println("Invalid Choice!");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Biomedical Waste Management System =====");

        System.out.println("1. Human Anatomical Waste");
        System.out.println("2. Sharps (Needles, Blades)");
        System.out.println("3. Expired Medicines");
        System.out.println("4. Contaminated Plastic Waste");
        System.out.println("5. Glassware");
        System.out.println("6. Chemical Waste");

        System.out.print("\nEnter Waste Category Number: ");
        int choice = sc.nextInt();

        classifyWaste(choice);

        sc.close();
    }
}