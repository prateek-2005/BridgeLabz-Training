import java.io.*;
public class filereader{
    public static void main(String[] args) throws Exception {
        String filePath = "que.txt";
        long startFileReader = System.nanoTime();
        FileReader fr = new FileReader(filePath);
        while (fr.read() != -1) {}
        fr.close();
        long endFileReader = System.nanoTime();
        System.out.println("FileReader Time: " + (endFileReader - startFileReader) + " ns");

        long startISR = System.nanoTime();
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
        while (isr.read() != -1) {}
        isr.close();
        long endISR = System.nanoTime();
        System.out.println("InputStreamReader Time: " + (endISR - startISR) + " ns");
    }
}
