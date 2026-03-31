import java.util.*;

public class PairSum {

    public static void findPair(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            int remaining= target - num;
            if (map.containsKey(remaining)) {
                System.out.println("Pair found: " + remaining + " + " + num + " = " + target);
                return;
            }
            map.put(num, 1);
        }
        System.out.println("No pair found with the given sum.");
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
        System.out.print("Enter target sum: ");
        int target = sc.nextInt();
        findPair(arr, target);
        sc.close();
    }
}

