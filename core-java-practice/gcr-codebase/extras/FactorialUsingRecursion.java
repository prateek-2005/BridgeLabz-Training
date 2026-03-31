import java.util.*;
public class FactorialUsingRecursion {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter The Number:");
		int n=sc.nextInt();
		int Ans=Factorial(n);
		System.out.println("Factorial Of "+n+" is "+Ans);
		sc.close();
	}
	public static int Factorial(int n) {
		if(n==0) {
			return 1;
		}
		return n*Factorial(n-1);
	}
}
