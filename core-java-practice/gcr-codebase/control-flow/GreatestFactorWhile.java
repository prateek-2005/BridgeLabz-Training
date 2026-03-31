import java.util.*;
public class GreatestFactorWhile {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		int greatestfactor=1;
		int temp=number-1;
		while(temp>=1) {
			if(number%temp==0) {
				greatestfactor=temp;
				break;
			}
			temp--;
		}
		System.out.println("Greatest Factor of "+number+" is "+greatestfactor);
		sc.close();
	}

}
