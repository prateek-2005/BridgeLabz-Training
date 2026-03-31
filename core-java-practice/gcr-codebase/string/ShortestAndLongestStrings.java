import java.util.*;
public class ShortestAndLongestStrings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] words = split(str);
        String[][] result = wordWithLength(words);
        System.out.println("Word\tLength");
        for (int i = 0; i < result.length; i++) {
            int len = Integer.parseInt(result[i][1]); 
            System.out.println(result[i][0] + "\t" + len);
        }
        String []ans=Check(result);
        System.out.println("Shortest String :"+ans[0]);
        System.out.println("Largest String :"+ans[1]);
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
    public static String[][] wordWithLength(String[] words) {
        String[][] arr = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            arr[i][0] = words[i];
            arr[i][1] = String.valueOf(find(words[i])); 
        }

        return arr;
    }
    public static String[] Check(String[][] result) {
        String[] ans = new String[2];
        String shortest = result[0][0];
        String largest = result[0][0];
        int minLen = Integer.parseInt(result[0][1]);
        int maxLen = Integer.parseInt(result[0][1]);
        for (int i = 1; i < result.length; i++) {
            int len = Integer.parseInt(result[i][1]);
            if (len < minLen) {
                minLen = len;
                shortest = result[i][0];
            }
            if (len > maxLen) {
                maxLen = len;
                largest = result[i][0];
            }
        }
        ans[0] = shortest;
        ans[1] = largest;
        return ans;
    }

}
