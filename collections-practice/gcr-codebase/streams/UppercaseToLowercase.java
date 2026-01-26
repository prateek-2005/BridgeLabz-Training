import java.io.*;
public class UppercaseToLowercase {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
            BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"));
        ) {
            int ch;
            while ((ch = reader.read()) != -1) {
                char converted = Character.toLowerCase((char) ch);
                writer.write(converted);
            }
            System.out.println("File converted successfully.");
        } catch (IOException e) {
            System.out.println("Error while processing file.");
            e.printStackTrace();
        }
    }
}
