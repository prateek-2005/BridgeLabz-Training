import java.util.*;
public class FirstNegativeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int result = find(arr);
        if (result != -1) {
            System.out.println("First negative number found at index: " + result);
        } else {
            System.out.println("No negative number found in the array");
        }

        sc.close();
    }

    public static int find(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }

}

