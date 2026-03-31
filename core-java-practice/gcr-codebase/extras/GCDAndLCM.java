import java.util.*;

public class GCDAndLCM {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1st Number:");
		int Number1 = sc.nextInt();
		System.out.println("Enter 2nd Number:");
		int Number2 = sc.nextInt();
		int Lcm = FindLcm(Number1, Number2);
		int Gcd = FindGcd(Number1, Number2);
		System.out.println("LCM Of Two Numbers Is:" + Lcm);
		System.out.println("GCD Of Two Numbers Is:" + Gcd);
	}

	public static int FindLcm(int num1, int num2) {
		return (num1 * num2) / FindGcd(num1, num2);
	}

	public static int FindGcd(int num1, int num2) {
		while (num2 != 0) {
			int temp =num2;
			num2=num1%num2;
			num1= temp;
		}
		return num1;
	}
}
