import java.util.*;
public class FirstSmallest {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int number1=sc.nextInt();
		int number2=sc.nextInt();
		int number3=sc.nextInt();
		if(number1<number2 && number1<number3) {
			System.out.println("Yes the first number is the smallest");
		}
		else {
			System.out.println("No the first number is not the smallest");
		}
		sc.close();
	}
}
