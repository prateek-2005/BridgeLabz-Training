package csv_data_handling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class MergeCSV {
    public static void main(String[] args) {
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "students_merged.csv";
        Map<String, String[]> studentDetailsMap = new HashMap<>();
        String line;
        try (
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            FileWriter writer = new FileWriter(outputFile)
        ) {
            br1.readLine();
            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");
                studentDetailsMap.put(data[0], new String[]{data[1], data[2]});
            }
            writer.append("ID,Name,Age,Marks,Grade\n");
            br2.readLine(); 
            while ((line = br2.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                if (studentDetailsMap.containsKey(id)) {
                    String[] student1Data = studentDetailsMap.get(id);
                    writer.append(
                        id + "," +
                        student1Data[0] + "," +
                        student1Data[1] + "," +
                        data[1] + "," +
                        data[2] + "\n"
                    );
                }
            }
            System.out.println("CSV files merged successfully!");

        } catch (IOException e) {
            System.out.println("Error processing files: " + e.getMessage());
        }
    }
}
