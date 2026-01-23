import java.util.*;

public class ReverseList{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            arrayList.add(val);
            linkedList.add(val);
        }
        int left = 0, right = arrayList.size() - 1;
        while (left < right) {
            int temp = arrayList.get(left);
            arrayList.set(left, arrayList.get(right));
            arrayList.set(right, temp);
            left++;
            right--;
        }
        LinkedList<Integer> reversedLinkedList = new LinkedList<>();
        for (int num : linkedList) {
            reversedLinkedList.addFirst(num);
        }
        System.out.println("Reversed ArrayList: " + arrayList);
        System.out.println("Reversed LinkedList: " + reversedLinkedList);
        sc.close();
    }
}

