import java.util.*;
public class ReverseQueue {
    static void reverse(Queue<Integer> q) {
        if (q.isEmpty()) return;
        int x = q.remove();
        reverse(q);
        q.add(x);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            q.add(sc.nextInt());
        }
        reverse(q);
        System.out.println("Reversed Queue: " + q);
        sc.close();
    }
}
