import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class CapitalizedWordExtractor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String sentence = sc.nextLine();
        String regex = "\\b[A-Z][a-z]*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sentence);
        boolean found = false;
        while (matcher.find()) {
            System.out.print(matcher.group());
            if (matcher.find()) {
                System.out.print(", ");
                matcher.region(matcher.start(), sentence.length());
            }
            found = true;
        }
        if (!found) {
            System.out.println("No capitalized words found");
        }
        sc.close();
    }
}
