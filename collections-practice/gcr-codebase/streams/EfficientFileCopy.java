import java.io.*;
public class EfficientFileCopy {
    private static final int BUFFER_SIZE = 4096;
    public static void main(String[] args) {
        String sourceFile = "largefile.txt";  
        String normalCopy = "normal_copy.txt";
        String bufferedCopy = "buffered_copy.txt";
        long normalTime = copyUsingNormalStreams(sourceFile, normalCopy);
        long bufferedTime = copyUsingBufferedStreams(sourceFile, bufferedCopy);
        System.out.println("\n--- Performance Result ---");
        System.out.println("Normal Streams Time   : " + normalTime + " ns");
        System.out.println("Buffered Streams Time : " + bufferedTime + " ns");

        if (bufferedTime < normalTime) {
            System.out.println("Buffered streams are faster");
        } else {
            System.out.println("Normal streams are faster");
        }
    }
    private static long copyUsingNormalStreams(String source, String dest) {
        long startTime = System.nanoTime();
        try (
            FileInputStream fis = new FileInputStream(source);
            FileOutputStream fos = new FileOutputStream(dest);
        ) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error in normal stream copy: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }
    private static long copyUsingBufferedStreams(String source, String dest) {
        long startTime = System.nanoTime();
        try (
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
        ) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error in buffered stream copy: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }
}
