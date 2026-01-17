import java.io.*;
public class CountOccurences {

	public static void main(String[] args) {
		String filePath = "D:/linear_and_binary_search/que.txt";
        String targetWord = "array";
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }
            System.out.println("The word '" + targetWord + "' appeared " + count + " times.");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
