import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ProgrammingLanguageExtractor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = sc.nextLine();
        String regex = "\\b(Java|Python|JavaScript|Go)\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        boolean found = false;
        boolean first = true;
        while (matcher.find()) {
            if (!first) {
                System.out.print(", ");
            }
            System.out.print(matcher.group());
            first = false;
            found = true;
        }
        if (!found) {
            System.out.println("No programming languages found");
        }
        sc.close();
    }
}
