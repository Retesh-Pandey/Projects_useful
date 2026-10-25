import java.util.ArrayList;
import java.util.Scanner;

class DesignProject {
    private String projectName;
    private String clientName;
    private String designType;
    private double budget;

    public DesignProject(String projectName, String clientName,
                         String designType, double budget) {
        this.projectName = projectName;
        this.clientName = clientName;
        this.designType = designType;
        this.budget = budget;
    }

    public String getProjectName() {
        return projectName;
    }

    public void display() {
        System.out.println("Project Name : " + projectName);
        System.out.println("Client Name  : " + clientName);
        System.out.println("Design Type  : " + designType);
        System.out.println("Budget       : ₹" + budget);
        System.out.println("----------------------------");
    }
}

public class DesignerPortfolio {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<DesignProject> projects = new ArrayList<>();

        while (true) {
            System.out.println("\n=== DESIGNER PORTFOLIO SYSTEM ===");
            System.out.println("1. Add Design Project");
            System.out.println("2. View All Projects");
            System.out.println("3. Search Project");
            System.out.println("4. Exit");
            System.out.print("Choose Option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Project Name: ");
                    String pName = sc.nextLine();

                    System.out.print("Client Name: ");
                    String cName = sc.nextLine();

                    System.out.print("Design Type (Logo/UI/Poster/etc): ");
                    String dType = sc.nextLine();

                    System.out.print("Budget: ");
                    double budget = sc.nextDouble();

                    projects.add(new DesignProject(
                            pName, cName, dType, budget));

                    System.out.println("Project Added Successfully!");
                    break;

                case 2:
                    if (projects.isEmpty()) {
                        System.out.println("No projects available.");
                    } else {
                        System.out.println("\n--- PROJECT LIST ---");
                        for (DesignProject p : projects) {
                            p.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Project Name: ");
                    String search = sc.nextLine();

                    boolean found = false;
                    for (DesignProject p : projects) {
                        if (p.getProjectName().equalsIgnoreCase(search)) {
                            p.display();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Project Not Found.");
                    }
                    break;

                case 4:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}