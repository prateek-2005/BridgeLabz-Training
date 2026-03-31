import java.util.*;

class Implementation {
	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();

	public void enqueue(int x) {
		stack1.push(x);
		System.out.println("Data Push: " + x);
	}

	public int dequeue() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		if (stack2.isEmpty()) {
			System.out.println("Queue is Empty");
			return -1;
		}
		return stack2.pop();
	}

	public int peek() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}

		if (stack2.isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}

		return stack2.peek();
	}
}

public class ImplementQueue {

	public static void main(String[] args) {
		Implementation q = new Implementation();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		System.out.println(q.dequeue());
		System.out.println(q.peek());
		System.out.println(q.dequeue());
	}

}
