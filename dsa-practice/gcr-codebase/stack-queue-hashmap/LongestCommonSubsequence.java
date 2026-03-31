import java.util.*;
public class LongestCommonSubsequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of array: ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter array elements:");
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("Longest Common Subsequence length: "+find(arr));
		sc.close();
	}
	public static int find(int []arr) {
		HashMap<Integer, Boolean> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, true);
        }
        int ans= 0;
        for (int num : arr) {
            if (!map.containsKey(num - 1)) {
                int current = num;
                int count = 1;
                while (map.containsKey(current + 1)) {
                    current++;
                    count++;
                }
                ans= Math.max(ans, count);
            }
        }
        return ans;
	}
}
