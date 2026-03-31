package csv_data_handling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class CountRows {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        String line;
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) { 
                    count++;
                }
            }
            System.out.println("Total number of records: " + count);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
