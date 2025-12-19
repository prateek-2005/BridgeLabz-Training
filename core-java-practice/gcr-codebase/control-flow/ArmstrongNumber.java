import java.util.*;
public class ArmstrongNumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int OriginalNumber=sc.nextInt();
		int sum=0;
		int N=OriginalNumber;
		while(N!=0) {
			int CurrentDigit=N%10;
			N=N/10;
			sum+=Math.pow(CurrentDigit, 3);
		}
		if(sum==OriginalNumber) {
			System.out.println(OriginalNumber+" is a Armstrong Number");
		}
		else {
			System.out.println(OriginalNumber+" is not a Armstrong Number");
		}
		sc.close();
	}

}
