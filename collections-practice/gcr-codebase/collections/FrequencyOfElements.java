import java.util.*;

public class FrequencyOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine();
        List<String> list = new ArrayList<>();
        System.out.println("Enter strings:");
        for (int i = 0; i < n; i++) {
        	String Str=sc.nextLine();
            list.add(Str);
        }
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : list) {
            if (freqMap.containsKey(word)) {
                freqMap.put(word, freqMap.get(word) + 1);
            } else {
                freqMap.put(word, 1);
            }
        }
        System.out.println("Input List: " + list);
        System.out.println("Frequency Map: " + freqMap);
        sc.close();
    }
}
