package Set2;
import java.util.*;
import java.util.regex.*;

class Validator {

    public static String validate(String s) {

        if (s.length() == 0)
            return "Invalid Input (empty string)";

        if (s.length() < 6)
            return "Invalid Input (length < 6)";

        if (Pattern.compile("\\s").matcher(s).find())
            return "Invalid Input (contains space)";

        if (Pattern.compile("\\d").matcher(s).find())
            return "Invalid Input (contains digits)";

        if (!Pattern.matches("[A-Za-z]+", s))
            return "Invalid Input (contains special character)";

        return "VALID";
    }
}

class KeyGenerator {

    public static String generateKey(String s) {

        s = s.toLowerCase();

        StringBuilder filtered = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c % 2 != 0)
                filtered.append(c);
        }

        filtered.reverse();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < filtered.length(); i++) {

            char c = filtered.charAt(i);

            if (i % 2 == 0)
                result.append(Character.toUpperCase(c));
            else
                result.append(c);
        }

        return result.toString();
    }
}

public class KeyGeneration {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {

            String input = sc.nextLine();

            String check = Validator.validate(input);

            if (!check.equals("VALID")) {
                System.out.println(check);
            } else {

                String key = KeyGenerator.generateKey(input);
                System.out.println("The generated key is - " + key);
            }
        }
        sc.close();
    }
}