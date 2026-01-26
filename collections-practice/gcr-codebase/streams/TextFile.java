import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TextFile{
    public static void main(String[] args) {
        String sourceFile = "input.txt";
        String destinationFile = "output.txt";
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(destinationFile);
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.out.println("Error: Source file not found or problem while reading/writing.");
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error while closing files.");
            }
        }
    }
}
