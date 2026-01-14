import java.util.*;

public class SortAStack {
	public static void sortStack(Stack<Integer> stack) {
		if (!stack.isEmpty()) {
			int top = stack.pop();
			sortStack(stack);
			insert(stack, top);
		}
	}

	public static void insert(Stack<Integer> stack, int x) {
		if (stack.isEmpty() || stack.peek() <= x) {
			stack.push(x);
			return;
		}
		int top = stack.pop();
		insert(stack, x);
		stack.push(top);
	}
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(4);
		stack.push(1);
		stack.push(3);
		stack.push(2);
		stack.push(5);
		System.out.println("Before Sorting: " + stack);
		sortStack(stack);
		System.out.println("After Sorting: " + stack);
	}
}
