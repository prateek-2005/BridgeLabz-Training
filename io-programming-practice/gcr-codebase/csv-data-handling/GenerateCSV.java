package csv_data_handling;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GenerateCSV {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/companydb";
        String username = "root";
        String password = "password";
        String outputFile = "employee_report.csv";
        String query = "SELECT emp_id, name, department, salary FROM employees";
        try (
            Connection con = DriverManager.getConnection(jdbcUrl, username, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            FileWriter writer = new FileWriter(outputFile)
        ) {
            writer.append("Employee ID,Name,Department,Salary\n");
            while (rs.next()) {
                writer.append(rs.getInt("emp_id") + ",");
                writer.append(rs.getString("name") + ",");
                writer.append(rs.getString("department") + ",");
                writer.append(rs.getDouble("salary") + "\n");
            }
            System.out.println("CSV report generated successfully!");

        } catch (Exception e) {
            System.out.println("Error generating CSV report: " + e.getMessage());
        }
    }
}
