import java.util.*;
public class SumOfNaturalNumbers {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println("Sum of "+n+" natural numbers is: "+find(n));
		sc.close();
	}
	public static int find(int n) {
		int sum=0;
		for(int i=1;i<=n;i++) {
			sum+=i;
		}
		return sum;
	}
}
