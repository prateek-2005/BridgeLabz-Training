import java.util.*;
public class CharacterFrequencyUsingNestedLoops{
    public static String[] find(String Str) {
        char[] ch = Str.toCharArray();
        int[] freq = new int[ch.length];
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '0')
                continue;
            freq[i] = 1;
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[i] == ch[j]) {
                    freq[i]++;
                    ch[j] = '0'; 
                }
            }
        }
        int count = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != '0') {
                count++;
            }
        }
        String[] ans= new String[count];
        int index = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != '0') {
                ans[index] = ch[i] + "\t\t" + freq[i];
                index++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String Str= sc.nextLine();
        String[] ans= find(Str);
        System.out.println("\nCharacter\tFrequency:");
        for (String i : ans) {
            System.out.println(i);
        }

        sc.close();
    }
}
