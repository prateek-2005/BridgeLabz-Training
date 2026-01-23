import java.util.*;
public class MergeTwoMaps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of entries in Map1: ");
        int n1 = sc.nextInt();
        sc.nextLine();
        HashMap<String, Integer> map1 = new HashMap<>();
        System.out.println("Enter key and value for Map1:");
        for (int i = 0; i < n1; i++) {
            String key = sc.nextLine();
            int value = sc.nextInt();
            sc.nextLine();
            map1.put(key, value);
        }
        System.out.print("Enter number of entries in Map2: ");
        int n2 = sc.nextInt();
        sc.nextLine();
        HashMap<String, Integer> map2 = new HashMap<>();
        System.out.println("Enter key and value for Map2:");
        for (int i = 0; i < n2; i++) {
            String key = sc.nextLine();
            int value = sc.nextInt();
            sc.nextLine();
            map2.put(key, value);
        }
        HashMap<String, Integer> result = new HashMap<>(map1);
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            result.put(key, result.getOrDefault(key, 0) + value);
        }
        System.out.println("Map1: " + map1);
        System.out.println("Map2: " + map2);
        System.out.println("Merged Map: " + result);
        sc.close();
    }
}
