import java.util.*;
public class NumberOfDigits {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		int count=0;
		int N=number;
		while(N!=0) {
			N=N/10;
			count++;
		}
		System.out.println("The Number of Digits in "+number+" are "+count);
		sc.close();
	}

}
