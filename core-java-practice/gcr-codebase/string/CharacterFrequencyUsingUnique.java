import java.util.*;

public class CharacterFrequencyUsingUnique {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String Str = sc.nextLine();
        String[][] ans = find(Str);
        System.out.println("Characters\tFrequency");
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + "\t\t" + ans[i][1]);
        }
        sc.close();
    }

    public static String[][] find(String Str) {
        int[] count = new int[256];

        for (int i = 0; i < Str.length(); i++) {
            char ch = Str.charAt(i);
            count[ch]++;
        }

        char[] uniqueChar = FindUnique(Str);
        String[][] arr = new String[uniqueChar.length][2];

        for (int i = 0; i < uniqueChar.length; i++) {
            char ch = uniqueChar[i];
            arr[i][0] = String.valueOf(ch);
            arr[i][1] = String.valueOf(count[ch]);
        }

        return arr;
    }

    public static char[] FindUnique(String Str) {
        char[] temp = new char[Str.length()];
        int index = 0;

        for (int i = 0; i < Str.length(); i++) {
            char currchar = Str.charAt(i);
            boolean check = true;

            for (int j = 0; j < index; j++) {
                if (temp[j] == currchar) {
                    check = false;
                    break;
                }
            }

            if (check) {
                temp[index++] = currchar;
            }
        }
        char[] unique = new char[index];
        for (int i = 0; i < index; i++) {
            unique[i] = temp[i];
        }

        return unique;
    }
}
