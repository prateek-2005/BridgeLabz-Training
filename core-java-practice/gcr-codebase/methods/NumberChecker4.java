import java.util.*;
public class NumberChecker4 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		if(isPrime(n)) {
			System.out.println(n+" is a prime number");
		}
		else {
			System.out.println(n+"is not a prime number");
		}
		if(isNeon(n)) {
			System.out.println(n+" is a Neon Number");
		}
		else {
			System.out.println(n+"is not a Neon Number");
		}
		if(isSpy(n)) {
			System.out.println(n+"is a Spy Number");
		}
		else {
			System.out.println(n+"is not a Spy Number");
		}
		if(isAutoMorphic(n)) {
			System.out.println(n+"is a Automorphic Number");
		}
		else {
			System.out.println(n+"is not a Automorphic Number");
		}
		if(isBuzz(n)) {
			System.out.println(n+"is a Buzz Number");
		}
		else {
			System.out.println(n+"is not a Buzz Number");
		}
		sc.close();
	}
	public static boolean isPrime(int n) {
		if(n<=1) {
			return false;
		}
		for(int i=2;i<Math.sqrt(n);i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
	public static boolean isNeon(int n) {
        int square = n* n;
        int sum = 0;
        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum==n;
    }
	public static boolean isSpy(int n) {
        int sum = 0, prod= 1;
        int temp = n;
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            prod*= digit;
            temp /= 10;
        }
        return sum==prod;
    }
	public static boolean isAutoMorphic(int n) {
        int square = n* n;
        String num= String.valueOf(n);
        String Str = String.valueOf(square);
        return Str.endsWith(num);
    }
	public static boolean isBuzz(int n) {
        return (n % 7 == 0) || (n % 10 == 7);
    }
}
