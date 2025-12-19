import java.util.*;
public class LargestOfThree {
	public static void main(String []args) {
		Scanner sc=new Scanner(System.in);
		int number1=sc.nextInt();
		int number2=sc.nextInt();
		int number3=sc.nextInt();
		if(number1>number2 && number2>number3) {
			System.out.println("Yes the first number is the largest");
		}
		else if(number2>number1 && number2>number3) {
			System.out.println("Yes the second number is the largest");
		}
		else {
			System.out.println("Yes the third number is the largest");
		}
		sc.close();
	}
}
