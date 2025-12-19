import java.util.*;
public class FactorialWhile {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int factorial=1;
		if(num>0) {
			int temp=num;
			while(temp>0) {
				factorial*=temp;
				temp--;
			}
		}
		System.out.println("Factorial of "+num+" is "+factorial);
		sc.close();
	}

}
