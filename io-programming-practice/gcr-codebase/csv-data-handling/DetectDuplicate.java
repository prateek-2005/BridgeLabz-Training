package csv_data_handling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
public class DetectDuplicate {
    public static void main(String[] args) {
        String filePath = "students.csv";
        String line;
        Set<String> seenIds = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            System.out.println("Duplicate Records:\n");
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                if (!seenIds.add(id)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }
}
