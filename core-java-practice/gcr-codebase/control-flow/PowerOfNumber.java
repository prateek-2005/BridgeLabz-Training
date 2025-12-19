import java.util.*;
public class PowerOfNumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		int power=sc.nextInt();
		int ans=1;
		if(number>0) {
			for(int i=1;i<=power;i++) {
				ans*=number;
			}
		}
		System.out.println(ans);
		sc.close();
	}

}
