import java.util.*;

public class ZeroSumSubarray {

    public static void find(int[] arr) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int sum = 0;
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                System.out.println("Subarray found from index 0 to " + i);
                found = true;
            }
            if (map.containsKey(sum)) {
                for (int startIndex : map.get(sum)) {
                    System.out.println("Subarray found from index " + (startIndex + 1) + " to " + i);
                    found = true;
                }
            }
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }

        if (!found) {
            System.out.println("No zero-sum subarrays found.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        find(arr);
        sc.close();
    }
}

