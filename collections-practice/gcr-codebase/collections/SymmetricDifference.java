import java.util.*;
public class SymmetricDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements in Set1: ");
        int n1 = sc.nextInt();
        HashSet<Integer> set1 = new HashSet<>();
        System.out.println("Enter elements of Set1:");
        for (int i = 0; i < n1; i++) {
            set1.add(sc.nextInt());
        }
        System.out.print("Enter number of elements in Set2: ");
        int n2 = sc.nextInt();
        HashSet<Integer> set2 = new HashSet<>();
        System.out.println("Enter elements of Set2:");
        for (int i = 0; i < n2; i++) {
            set2.add(sc.nextInt());
        }
        HashSet<Integer> result = new HashSet<>(set1);
        result.addAll(set2);
        HashSet<Integer> common = new HashSet<>(set1);
        common.retainAll(set2);
        result.removeAll(common);
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Symmetric Difference: " + result);
        sc.close();
    }
}
