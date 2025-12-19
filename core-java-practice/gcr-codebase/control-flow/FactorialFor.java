import java.util.*;
public class FactorialFor {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int factorial=1;
		if(num>0) {
			for(int i=1;i<=num;i++) {
				factorial*=i;
			}
		}
		System.out.println("Factorial of "+num+" is "+factorial);
		sc.close();
	}

}
