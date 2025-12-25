import java.util.*;
public class NumberChecker5 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		if(isPerfect(n)) {
			System.out.println(n+" is a perfect number");
		}
		else {
			System.out.println(n+"is not a perfect number");
		}
		if(isAbundant(n)) {
			System.out.println(n+" is a Abundant Number");
		}
		else {
			System.out.println(n+" is not a Abundant Number");
		}
		if(isDeficient(n)) {
			System.out.println(n+" is a Deficient Number");
		}
		else {
			System.out.println(n+" is not a Deficient Number");
		}
		if(isStrong(n)) {
			System.out.println(n+" is a Strong Number");
		}
		else {
			System.out.println(n+"is not a Strong Number");
		}
		sc.close();
	}
	public static boolean isPerfect(int n) {
		if (n<= 1) return false;
        return sum(n)==n;
	}
	public static boolean isAbundant(int n) {
	    if (n<= 0) return false;
	    return sum(n)>n;
	}
	public static boolean isDeficient(int n) {
        if (n<= 0) return false;
        return sum(n)<n;
    }
	public static int sum(int n) {
		int Sum = 1; 
        for (int i = 2; i <= n/ 2; i++) {
            if (n% i == 0) {
                Sum+= i;
            }
        }
        return Sum;
	}
	public static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    public static boolean isStrong(int n) {
        int sum = 0;
        int temp = n;
        while (temp > 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }
        return sum == n;
    }

}
