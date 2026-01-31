import java.util.*;
public class LexicalTwist {
    private static boolean isInvalidWord(String s) {
        return s.trim().contains(" ");
    }
    private static boolean isVowel(char ch) {
        return "AEIOUaeiou".indexOf(ch) != -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first word");
        String first = sc.nextLine();
        if (isInvalidWord(first)) {
            System.out.println(first + " is an invalid word");
            sc.close();
            return;
        }
        System.out.println("Enter the second word");
        String second = sc.nextLine();
        if (isInvalidWord(second)) {
            System.out.println(second + " is an invalid word");
            sc.close();
            return;
        }
        String reversedFirst = new StringBuilder(first).reverse().toString();
        if (reversedFirst.equalsIgnoreCase(second)) {
            String result = reversedFirst.toLowerCase();
            result = result.replaceAll("[aeiou]", "@");
            System.out.println(result);
        } else {
            String combined = (first + second).toUpperCase();
            int vowels = 0, consonants = 0;
            for (char ch : combined.toCharArray()) {
                if (Character.isLetter(ch)) {
                    if (isVowel(ch))
                        vowels++;
                    else
                        consonants++;
                }
            }
            if (vowels > consonants) {
                LinkedHashSet<Character> set = new LinkedHashSet<>();
                for (char ch : combined.toCharArray()) {
                    if (isVowel(ch))
                        set.add(ch);
                }
                int count = 0;
                for (char ch : set) {
                    System.out.print(ch);
                    count++;
                    if (count == 2) break;
                }

            } else if (consonants > vowels) {
                LinkedHashSet<Character> set = new LinkedHashSet<>();
                for (char ch : combined.toCharArray()) {
                    if (Character.isLetter(ch) && !isVowel(ch))
                        set.add(ch);
                }

                int count = 0;
                for (char ch : set) {
                    System.out.print(ch);
                    count++;
                    if (count == 2) break;
                }
            } else {
                System.out.println("Vowels and consonants are equal");
            }
        }

        sc.close();
    }
}
