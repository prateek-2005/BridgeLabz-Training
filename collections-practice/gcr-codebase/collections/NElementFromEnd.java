import java.util.*;

public class NElementFromEnd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        sc.nextLine();
        LinkedList<String> list = new LinkedList<>();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }
        System.out.print("Enter N: ");
        int k = sc.nextInt();
        Iterator<String> fast = list.iterator();
        Iterator<String> slow = list.iterator();
        for (int i = 0; i < k; i++) {
            if (!fast.hasNext()) {
                System.out.println("N is greater than list size");
                return;
            }
            fast.next();
        }
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }
        System.out.println("List: " + list);
        System.out.println("Nth element from end: " + slow.next());
        sc.close();
    }
}
