import java.util.*;
public class SetToSortedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        System.out.println("Set: " + set);
        System.out.println("Sorted List: " + list);
        sc.close();
    }
}
