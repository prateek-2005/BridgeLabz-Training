package Set4;
import java.util.*;
import java.util.regex.*;

class PlaceholderHandler {

    public static String process(String type, String value) {

        try {

            switch (type) {

                case "UPPER":
                    return value.toUpperCase();

                case "LOWER":
                    return value.toLowerCase();

                case "DATE":
                    String[] parts = value.split("-");
                    int day = Integer.parseInt(parts[0]);
                    int month = Integer.parseInt(parts[1]);
                    int year = Integer.parseInt(parts[2]);

                    if (day < 1 || day > 31 || month < 1 || month > 12)
                        return "INVALID";

                    return year + "/" +
                           String.format("%02d", month) + "/" +
                           String.format("%02d", day);

                case "REPEAT":
                    String[] r = value.split(",");
                    String word = r[0];
                    int count = Integer.parseInt(r[1]);

                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < count; i++)
                        sb.append(word);

                    return sb.toString();

                default:
                    return "INVALID";
            }

        } catch (Exception e) {
            return "INVALID";
        }
    }
}

class TemplateProcessor {

    private static final Pattern pattern =
            Pattern.compile("\\$\\{([A-Z]+):([^}]+)\\}");

    public static String processTemplate(String line) {

        Matcher matcher = pattern.matcher(line);
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {

            String type = matcher.group(1);
            String value = matcher.group(2);

            String replacement = PlaceholderHandler.process(type, value);

            matcher.appendReplacement(result, replacement);
        }

        matcher.appendTail(result);

        return result.toString();
    }
}

public class DynamicTemplateProcessor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();
            System.out.println(TemplateProcessor.processTemplate(line));
        }
        sc.close();
    }
}