import java.util.*;

class Book {
    int id;
    String title;
    boolean issued;
    int issueDay;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.issued = false;
        this.issueDay = 0;
    }
}

public class LibraryIssueSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        books.add(new Book(101, "Java Programming"));
        books.add(new Book(102, "Data Structures"));
        books.add(new Book(103, "Operating Systems"));
        books.add(new Book(104, "Database Management"));

        while (true) {
            System.out.println("\n===== LIBRARY ISSUE SYSTEM =====");
            System.out.println("1. View Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    displayBooks();
                    break;

                case 2:
                    issueBook();
                    break;

                case 3:
                    returnBook();
                    break;

                case 4:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    static void displayBooks() {
        System.out.println("\nAvailable Books:");
        for (Book b : books) {
            System.out.println("ID: " + b.id +
                    " | Title: " + b.title +
                    " | Status: " + (b.issued ? "Issued" : "Available"));
        }
    }

    static void issueBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                if (!b.issued) {
                    System.out.print("Enter Current Day Number: ");
                    int day = sc.nextInt();

                    b.issued = true;
                    b.issueDay = day;

                    System.out.println("Book Issued Successfully!");
                } else {
                    System.out.println("Book Already Issued!");
                }
                return;
            }
        }

        System.out.println("Book Not Found!");
    }

    static void returnBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {

                if (b.issued) {

                    System.out.print("Enter Return Day Number: ");
                    int returnDay = sc.nextInt();

                    int daysUsed = returnDay - b.issueDay;
                    int fine = 0;

                    if (daysUsed > 14) {
                        fine = (daysUsed - 14) * 5; // ₹5 per extra day
                    }

                    b.issued = false;
                    b.issueDay = 0;

                    System.out.println("Book Returned Successfully!");
                    System.out.println("Days Used: " + daysUsed);
                    System.out.println("Fine Amount: ₹" + fine);

                } else {
                    System.out.println("This Book Was Not Issued!");
                }
                return;
            }
        }

        System.out.println("Book Not Found!");
    }
}