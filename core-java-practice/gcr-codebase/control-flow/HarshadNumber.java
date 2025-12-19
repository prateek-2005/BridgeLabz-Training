import java.util.*;
public class HarshadNumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		int sum=0;
		int N=number;
		while(N!=0) {
			int currentdigit=N%10;
			N=N/10;
			sum+=currentdigit;
		}
		if(number%sum==0) {
			System.out.println(number+" Harshad Number");
		}
		else {
			System.out.println(number+ " is Not a Harshad Number");
		}
		sc.close();
	}

}
