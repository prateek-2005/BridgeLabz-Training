import java.io.*;
public class ChallengeProblem {

    public static void main(String[] args) {
        int iterations = 1_000_000;
        String text = "hello";
        StringBuilder sb = new StringBuilder();
        long sbStart = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long sbEnd = System.nanoTime();
        System.out.println("StringBuilder time: " + (sbEnd - sbStart) / 1_000_000 + " ms");
        StringBuffer sf = new StringBuffer();
        long sfStart = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            sf.append(text);
        }

        long sfEnd = System.nanoTime();
        System.out.println("StringBuffer time : " + (sfEnd - sfStart) / 1_000_000 + " ms");
        String filePath = "D:/linear_and_binary_search/que.txt"; 
        System.out.println("\n--- FileReader Test ---");
        countWordsUsingFileReader(filePath);
        System.out.println("\n--- InputStreamReader Test ---");
        countWordsUsingInputStreamReader(filePath);
    }
    public static void countWordsUsingFileReader(String filePath) {
        long start = System.currentTimeMillis();
        int wordCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty())
                    wordCount += words.length;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("Words: " + wordCount);
        System.out.println("Time : " + (end - start) + " ms");
    }
    public static void countWordsUsingInputStreamReader(String filePath) {
        long start = System.currentTimeMillis();
        int wordCount = 0;

        try (
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr)
        ) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty())
                    wordCount += words.length;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("Words: " + wordCount);
        System.out.println("Time : " + (end - start) + " ms");
    }
}
