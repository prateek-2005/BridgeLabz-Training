import java.util.*;
public class ChallengeProblem2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter array size: ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter elements:");
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int missing = firstMissingPositive(arr);
		System.out.println("First missing positive: " + missing);
		System.out.print("Enter target for binary search: ");
		int target = sc.nextInt();
		Arrays.sort(arr);
		System.out.println("Sorted array: " + Arrays.toString(arr));
		int index = binarySearch(arr, target);
		System.out.println("Target index: " + index);
		sc.close();
	}
	public static int firstMissingPositive(int[] arr) {
		int n = arr.length;
		boolean[] present = new boolean[n + 1];
		for (int num : arr) {
			if (num > 0 && num <= n) {
				present[num] = true;
			}
		}
		for (int i = 1; i <= n; i++) {
			if (!present[i]) {
				return i;
			}
		}
		return n + 1;
	}
	public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
            	return mid;
            }
            else if (arr[mid] < target) {
            	left = mid + 1;
            }
            else {
            	right = mid - 1;
            }
        }
        return -1;
    }
}
