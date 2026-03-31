import java.util.*;
public class InvertMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of entries: ");
        int n = sc.nextInt();
        sc.nextLine();
        HashMap<String, Integer> original = new HashMap<>();
        System.out.println("Enter key and value:");
        for (int i = 0; i < n; i++) {
            String key = sc.nextLine();
            int value = sc.nextInt();
            sc.nextLine();
            original.put(key, value);
        }
        HashMap<Integer, ArrayList<String>> inverted = new HashMap<>();
        for (Map.Entry<String, Integer> entry : original.entrySet()) {
            int val = entry.getValue();
            String key = entry.getKey();
            if (!inverted.containsKey(val)) {
                inverted.put(val, new ArrayList<>());
            }
            inverted.get(val).add(key);
        }
        System.out.println("Original Map: " + original);
        System.out.println("Inverted Map: " + inverted);
        sc.close();
    }
}
