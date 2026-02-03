package jsonhandling;
import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.*;

public class JsonReport {
    public static void main(String[] args) {

        String jdbcURL = "jdbc:mysql://localhost:3306/testdb"; 
        String username = "root";
        String password = "password";
        String query = "SELECT id, name, age, email FROM users";
        try (Connection conn = DriverManager.getConnection(jdbcURL, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            JSONArray jsonArray = new JSONArray();

            while (rs.next()) {
                JSONObject obj = new JSONObject();
                obj.put("id", rs.getInt("id"));
                obj.put("name", rs.getString("name"));
                obj.put("age", rs.getInt("age"));
                obj.put("email", rs.getString("email"));

                jsonArray.put(obj);
            }

            System.out.println(jsonArray.toString(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
