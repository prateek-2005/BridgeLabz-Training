import java.util.*;
public class MaximumOfThree {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int number1=sc.nextInt();
		int number2=sc.nextInt();
		int number3=sc.nextInt();
		int maximum=find(number1,number2,number3);
		System.out.println("Maximum Number: "+maximum);
	}
	public static int find(int num1,int num2,int num3) {
		if(num1>=num2 && num1>=num3) {
			return num1;
		}
		else if(num2>=num1 && num2>=num3) {
			return num2;
		}
		else {
			return num3;
		}
	}
}
