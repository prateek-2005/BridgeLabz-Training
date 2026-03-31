import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class FindRepeatingWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter sentence:");
        String sentence = sc.nextLine();
        String regex = "\\b(\\w+)\\s+\\1\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(sentence);
        boolean found = false;
        boolean first = true;
        while (matcher.find()) {
            if (!first) {
                System.out.print(", ");
            }
            System.out.print(matcher.group(1)); 
            first = false;
            found = true;
        }
        if (!found) {
            System.out.println("No repeating words found");
        }
        sc.close();
    }
}
