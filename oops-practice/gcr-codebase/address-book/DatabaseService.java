package address_book;
import java.sql.*;
import java.util.List;
public class DatabaseService {
    static final String URL = "jdbc:mysql://localhost:3306/addressbook";
    static final String USER = "root";
    static final String PASS = "password";
    public static void saveContacts(List<Contact> contacts) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            String query = "INSERT INTO contacts VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            for (Contact c : contacts) {
                ps.setString(1, c.firstName);
                ps.setString(2, c.lastName);
                ps.setString(3, c.address);
                ps.setString(4, c.city);
                ps.setString(5, c.state);
                ps.setString(6, c.zip);
                ps.setString(7, c.phone);
                ps.setString(8, c.email);
                ps.executeUpdate();
            }
            conn.close();
            System.out.println("Saved to database.");
        } catch (Exception e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
