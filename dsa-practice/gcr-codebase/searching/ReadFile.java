import java.io.*;

public class ReadFile {
    public static void main(String[] args) {
    	String filePath = "D:\\linear_and_binary_search\\que.txt";
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

