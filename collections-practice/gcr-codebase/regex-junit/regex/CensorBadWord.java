import java.util.Scanner;
public class CensorBadWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter sentence:");
        String sentence = sc.nextLine();
        System.out.println("Enter bad words (comma separated):");
        String badWordsInput = sc.nextLine();
        String[] badWords = badWordsInput.split(",");
        for (String word : badWords) {
            word = word.trim();
            sentence = sentence.replaceAll("(?i)\\b" + word + "\\b", "****");
        }
        System.out.println("Censored sentence:");
        System.out.println(sentence);
        sc.close();
    }
}
