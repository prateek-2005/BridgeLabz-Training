package jsonhandling;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvToJson {
    public static void main(String[] args) {
        String csvFile = "data.csv";
        String line;
        String delimiter = ",";
        JSONArray jsonArray = new JSONArray();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            
            String[] headers = br.readLine().split(delimiter);

            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                JSONObject obj = new JSONObject();

                for (int i = 0; i < headers.length; i++) {
                    obj.put(headers[i], values[i]);
                }

                jsonArray.put(obj);
            }

            System.out.println(jsonArray.toString(2)); 

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
