import java.util.Scanner;

public class BusinessCardGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Company Name: ");
        String company = sc.nextLine();
        System.out.print("Enter Your Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Job Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Contact Number: ");
        String phone = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        String border = "+--------------------------------------+";

        System.out.println("\n" + border);
        System.out.printf("| %-36s |\n", company);
        System.out.println("|                                      |");
        System.out.printf("| %-36s |\n", name);
        System.out.printf("| %-36s |\n", title);
        System.out.println("|                                      |");
        System.out.printf("| Phone: %-28s |\n", phone);
        System.out.printf("| Email: %-28s |\n", email);
        System.out.println(border);
    }
}
