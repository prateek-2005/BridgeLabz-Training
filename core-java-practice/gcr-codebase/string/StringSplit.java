import java.util.*;

public class StringSplit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] SplitUsingCharAt = split(str);
        String[] SplitUsingInBuilt = str.split(" ");

        System.out.println("Words Using CharAt:");
        for (String word : SplitUsingCharAt) {
            System.out.print(word + " ");
        }

        System.out.println("\n\nWords Using Inbuilt:");
        for (String word : SplitUsingInBuilt) {
            System.out.print(word + " ");
        }

        System.out.println();
        if (check(SplitUsingCharAt, SplitUsingInBuilt)) {
            System.out.println("Both Words Arrays are same");
        } else {
            System.out.println("Both Words Arrays are not same");
        }

        sc.close();
    }
    public static int find(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
        }
        return count;
    }
    public static String[] split(String str) {
        int length = find(str);

        if (length == 0) {
            return new String[0];
        }

        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                wordCount++;
            }
        }

        int[] spaceIndexes = new int[wordCount - 1];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                spaceIndexes[index++] = i;
            }
        }

        String[] words = new String[wordCount];
        int start = 0;

        for (int i = 0; i < spaceIndexes.length; i++) {
            int end = spaceIndexes[i];
            words[i] = str.substring(start, end);
            start = end + 1;
        }
        words[wordCount - 1] = str.substring(start);

        return words;
    }
    public static boolean check(String[] SplitUsingCharAt, String[] SplitUsingInBuilt) {
        if (SplitUsingCharAt.length != SplitUsingInBuilt.length) {
            return false;
        }

        for (int i = 0; i < SplitUsingCharAt.length; i++) {
            if (!SplitUsingCharAt[i].equals(SplitUsingInBuilt[i])) {
                return false;
            }
        }
        return true;
    }
}
