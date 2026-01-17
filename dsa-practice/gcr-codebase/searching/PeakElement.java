import java.util.*;
public class PeakElement {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int peak = find(arr);
        System.out.println("Peak element is: " + peak);
        sc.close();
    }
	public static int find(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean leftOk = (mid == 0) || arr[mid] > arr[mid - 1];
            boolean rightOk = (mid == n - 1) || arr[mid] > arr[mid + 1];
            if (leftOk && rightOk) {
                return arr[mid];
            }
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
