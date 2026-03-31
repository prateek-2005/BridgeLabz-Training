import java.io.*;
public class TryWithResources {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("info.txt"))) {
            String line = br.readLine();
            if (line != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
