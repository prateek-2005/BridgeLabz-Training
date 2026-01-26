import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
public class ByteArrayImage {
    public static void main(String[] args) {
        String originalImage = "input.jpg";  
        String newImage = "output.jpg";
        try {
            FileInputStream fis = new FileInputStream(originalImage);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            byte[] imageBytes = baos.toByteArray();
            fis.close();
            baos.close();
            System.out.println("Image converted to byte array. Size: " + imageBytes.length + " bytes");
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream(newImage);
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            bais.close();
            fos.close();
            System.out.println("New image created successfully.");
            byte[] originalBytes = Files.readAllBytes(new File(originalImage).toPath());
            byte[] copiedBytes = Files.readAllBytes(new File(newImage).toPath());
            if (Arrays.equals(originalBytes, copiedBytes)) {
                System.out.println("Verification Success: Both images are identical");
            } else {
                System.out.println("Verification Failed: Images are different ");
            }
        } catch (IOException e) {
            System.out.println("Error occurred while processing image.");
            e.printStackTrace();
        }
    }
}
