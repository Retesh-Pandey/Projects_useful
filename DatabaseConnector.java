import java.sql.*;
import java.util.Scanner;

public class DatabaseConnector {
    private static Connection connectToDB(String dbType) throws Exception {
        switch (dbType.toLowerCase()) {
            case "mysql":
                Class.forName("com.mysql.cj.jdbc.Driver");
                return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb", "root", "password");
            case "postgresql":
                Class.forName("org.postgresql.Driver");
                return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/testdb", "postgres", "password");
            case "sqlite":
                Class.forName("org.sqlite.JDBC");
                return DriverManager.getConnection("jdbc:sqlite:test.db");
            default:
                throw new IllegalArgumentException("Unsupported database type!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter database type (mysql/postgresql/sqlite): ");
        String dbType = sc.nextLine();

        try (Connection conn = connectToDB(dbType)) {
            System.out.println("Connected to " + dbType + " successfully!");
            System.out.print("Enter SQL query: ");
            String query = sc.nextLine();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ResultSetMetaData meta = rs.getMetaData();
            int columns = meta.getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
