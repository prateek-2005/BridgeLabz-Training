import java.util.*;
public class Divison {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num1=sc.nextInt();
		int num2=sc.nextInt();
		int []ans=QuotientAndRemainder(num1,num2);
		System.out.println("Quotient: "+ans[0]);
		System.out.println("Remainder: "+ans[1]);
		sc.close();
	}
	public static int[] QuotientAndRemainder(int num1,int num2) {
		int Quotient=num1/num2;
		int Remainder=num1%num2;
		return new int[] {Quotient,Remainder};
	}
}
