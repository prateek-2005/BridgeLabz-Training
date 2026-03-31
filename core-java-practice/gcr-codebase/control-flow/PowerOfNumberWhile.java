import java.util.*;
public class PowerOfNumberWhile {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		int power=sc.nextInt();
		int ans=1;
		int i=1;
		if(number>0) {
			while(i<=power){
				ans*=number;
				i++;
			}
		}
		System.out.println(ans);
		sc.close();
	}

}
