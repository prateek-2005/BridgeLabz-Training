import java.util.*;
public class FibonacciSequenceGenrator {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		print(n);
		sc.close();
	}
	public static void print(int n) {
		int first=0;
		int second=1;
		System.out.println("Fibonacci Sequence upto Nth Terms:");
		for (int i=1;i <=n;i++) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
	}
}
