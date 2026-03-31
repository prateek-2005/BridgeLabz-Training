import java.io.*;

public class ByteToChar{
    public static void main(String[] args) {
        String filePath = "D:/linear_and_binary_search/que.txt";
        String charset = "UTF-8";

        try (
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis, charset);
            BufferedReader br = new BufferedReader(isr);
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported charset: " + charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

