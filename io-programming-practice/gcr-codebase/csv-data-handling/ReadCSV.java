package csv_data_handling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class ReadCSV {
    private static final int CHUNK_SIZE = 100;
    public static void main(String[] args) {
        String filePath = "large_file.csv";
        String line;
        int totalRecords = 0;
        List<String> buffer = new ArrayList<>(CHUNK_SIZE);
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                buffer.add(line);
                if (buffer.size() == CHUNK_SIZE) {
                    processChunk(buffer);
                    totalRecords += buffer.size();
                    buffer.clear();
                }
            }
            if (!buffer.isEmpty()) {
                processChunk(buffer);
                totalRecords += buffer.size();
                buffer.clear();
            }
            System.out.println("Total records processed: " + totalRecords);

        } catch (IOException e) {
            System.out.println("Error reading large CSV file: " + e.getMessage());
        }
    }

    private static void processChunk(List<String> chunk) {
        System.out.println("Processed chunk of size: " + chunk.size());
    }
}
