import java.util.*;
public class ImplementStackUsingQueues {
    static class Stack {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        void push(int x) {
            q2.add(x);
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }
        int pop() {
            return q1.remove();
        }
        int top() {
            return q1.peek();
        }
        boolean isEmpty() {
            return q1.isEmpty();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();
        System.out.print("Enter number of operations: ");
        int n = sc.nextInt();
        System.out.println("Enter operations (1 push, 2 pop, 3 top):");
        for (int i = 0; i < n; i++) {
            int op = sc.nextInt();
            if (op == 1) {
                int val = sc.nextInt();
                stack.push(val);
            } 
            else if (op == 2) {
                if (!stack.isEmpty())
                    System.out.println("Popped: " + stack.pop());
                else
                    System.out.println("Stack is empty");
            } 
            else if (op == 3) {
                if (!stack.isEmpty())
                    System.out.println("Top: " + stack.top());
                else
                    System.out.println("Stack is empty");
            }
        }
        sc.close();
    }
}
