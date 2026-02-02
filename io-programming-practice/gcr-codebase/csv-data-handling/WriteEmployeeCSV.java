package csv_data_handling;
import java.io.FileWriter;
import java.io.IOException;
public class WriteEmployeeCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("ID,Name,Department,Salary\n");
            writer.append("101,Amit,IT,50000\n");
            writer.append("102,Rahul,HR,45000\n");
            writer.append("103,Neha,Finance,55000\n");
            writer.append("104,Priya,Marketing,48000\n");
            writer.append("105,Suresh,Operations,52000\n");
            System.out.println("Employee data written to CSV file successfully.");

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
