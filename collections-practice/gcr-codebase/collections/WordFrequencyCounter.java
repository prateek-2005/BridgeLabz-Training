import java.util.*;
import java.io.*;
public class WordFrequencyCounter {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String path = sc.nextLine();
        HashMap<String, Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while ((line = br.readLine()) != null) {
            line = line.toLowerCase().replaceAll("[^a-z0-9 ]", "");
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (word.length() > 0) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }
            }
        }
        br.close();
        System.out.println(map);
        sc.close();
    }
}
