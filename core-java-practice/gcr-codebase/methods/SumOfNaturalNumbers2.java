import java.util.*;
public class SumOfNaturalNumbers2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int RecursiveSum=Recursion(n);
		int FormulaSum=Formula(n);
		System.out.println("Sum Using Recursion: "+RecursiveSum);
		System.out.println("Sum Using Formula: "+FormulaSum);
		if(RecursiveSum==FormulaSum) {
			System.out.println("Both Sum Are Equal");
		}
		else {
			System.out.println("Both Sum Are Not Equal");
		}
		sc.close();
	}
	public static int Recursion(int n) {
		if(n==0) {
			return 0;
		}
		return n+Recursion(n-1);
	}
	public static int Formula(int n) {
		return (n*(n+1))/2;
	}
}
