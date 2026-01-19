import java.util.*;
public class datastructure {

    public static void main(String[] args) {
        int n = 1000000;
        int target = n - 1;
        int[] array = new int[n];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }
        long startArray = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target)
                break;
        }
        long endArray = System.nanoTime();
        System.out.println("Array Search Time: " + (endArray - startArray) + " ns");
        long startHash = System.nanoTime();
        hashSet.contains(target);
        long endHash = System.nanoTime();
        System.out.println("HashSet Search Time: " + (endHash - startHash) + " ns");
        long startTree = System.nanoTime();
        treeSet.contains(target);
        long endTree = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (endTree - startTree) + " ns");
    }
}
