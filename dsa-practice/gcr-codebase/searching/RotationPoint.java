import java.util.*;

public class RotationPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements (rotated sorted array): ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int index = find(arr);
        System.out.println("Rotation point index: " + index);
        System.out.println("Smallest element: " + arr[index]);
        sc.close();
    }
    public static int find(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } 
            else {
                right = mid;
            }
        }
        return left;
    }

}

