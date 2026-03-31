import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class DateExtractor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = sc.nextLine();
        String regex = "\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        boolean found = false;
        while (matcher.find()) {
            System.out.print(matcher.group());
            if (matcher.find()) {
                System.out.print(", ");
                matcher.region(matcher.start(), text.length());
            }
            found = true;
        }
        if (!found) {
            System.out.println("No dates found");
        }
        sc.close();
    }
}
