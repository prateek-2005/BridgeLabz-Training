import java.util.*;
public class HighestValueKey {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of entries: ");
        int n = sc.nextInt();
        sc.nextLine();
        HashMap<String, Integer> map = new HashMap<>();
        System.out.println("Enter key and value:");
        for (int i = 0; i < n; i++) {
            String key = sc.nextLine();
            int value = sc.nextInt();
            sc.nextLine();
            map.put(key, value);
        }
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        System.out.println("Map: " + map);
        System.out.println("Key with highest value: " + maxKey);
        sc.close();
    }
}
