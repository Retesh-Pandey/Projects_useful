import java.util.Scanner;

public class FrontendComponentGenerator {

    public static void generateButton(String text, String color) {
        System.out.println("\nGenerated Button:");
        System.out.println("<button style='background:" + color +
                "; color:white; padding:10px; border:none;'>"
                + text + "</button>");
    }

    public static void generateCard(String title) {
        System.out.println("\nGenerated Card:");
        System.out.println("<div class='card'>");
        System.out.println("   <h2>" + title + "</h2>");
        System.out.println("   <p>Card Description</p>");
        System.out.println("</div>");
    }

    public static void generateNavbar(String brand) {
        System.out.println("\nGenerated Navbar:");
        System.out.println("<nav>");
        System.out.println("   <h1>" + brand + "</h1>");
        System.out.println("</nav>");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Frontend Component Generator");
        System.out.println("1. Button");
        System.out.println("2. Card");
        System.out.println("3. Navbar");

        System.out.print("Choose Component: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch(choice) {
            case 1:
                System.out.print("Button Text: ");
                String text = sc.nextLine();
                System.out.print("Button Color: ");
                String color = sc.nextLine();
                generateButton(text, color);
                break;

            case 2:
                System.out.print("Card Title: ");
                String title = sc.nextLine();
                generateCard(title);
                break;

            case 3:
                System.out.print("Brand Name: ");
                String brand = sc.nextLine();
                generateNavbar(brand);
                break;

            default:
                System.out.println("Invalid Choice!");
        }

        sc.close();
    }
}