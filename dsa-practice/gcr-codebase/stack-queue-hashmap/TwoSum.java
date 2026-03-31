import java.util.*;
class TwoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter target sum: ");
        int target = sc.nextInt();
        int[] ans= find(nums, target);
        if (ans[0] == -1) {
            System.out.println("No pair found!");
        } else {
            System.out.println("Index: " + ans[0] + " and " + ans[1]);
        }
    }
    public static int[] find(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remaining= target - nums[i];
            if (map.containsKey(remaining)) {
                return new int[]{map.get(remaining), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}

