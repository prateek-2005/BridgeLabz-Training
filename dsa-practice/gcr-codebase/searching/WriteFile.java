import java.io.*;

public class WriteFile {
    public static void main(String[] args) {
        String filePath = "D:/linear_and_binary_search/user_input.txt";
        System.out.println("Enter text (type 'exit' to stop):");
        try (
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            FileWriter fw = new FileWriter(filePath, true); 
        ) {
            String line;
            while (true) {
                line = br.readLine();
                if (line.equalsIgnoreCase("exit")) {
                    System.out.println("Input saved. Program ended.");
                    break;
                }
                fw.write(line + System.lineSeparator());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

