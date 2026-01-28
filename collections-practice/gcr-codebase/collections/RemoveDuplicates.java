import java.util.*;

public class RemoveDuplicates{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int num : list) {
            set.add(num);
        }
        ArrayList<Integer> result = new ArrayList<>(set);
        System.out.println("Original List: " + list);
        System.out.println("After Removing Duplicates: " + result);
        sc.close();
    }
}


