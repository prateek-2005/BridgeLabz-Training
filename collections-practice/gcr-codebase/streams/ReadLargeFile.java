import java.io.*;
public class ReadLargeFile {
    public static void main(String[] args) {
        String filePath = "largefile.txt";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } 
        catch (IOException e) {
            System.out.println("Error while reading file.");
            e.printStackTrace();
        }
    }
}
