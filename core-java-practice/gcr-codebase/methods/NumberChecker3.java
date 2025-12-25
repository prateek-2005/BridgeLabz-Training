import java.util.*;
public class NumberChecker3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String[] Digits = Store(n);
        System.out.println("Count Of Digits In Number: " + Digits.length);
        System.out.println("Digits in number:");
        for (String d : Digits) {
            System.out.print(d + " ");
        }
        System.out.println();
        System.out.println("Reversed Digits Array: ");
        String []rev=Reversed(Digits);
        for (String d :rev) {
            System.out.print(d + " ");
        }
        System.out.println();
        if(check(Digits,rev)) {
        	System.out.println(n+" is a Pallindrome number");
        }
        else {
        	System.out.println(n+" is not a Pallindrome number");
        }
        if (CheckDuck(Digits)) {
            System.out.println(n + " is a duck number");
        } else {
            System.out.println(n + " is not a duck number");
        }
        sc.close();
	}
	public static String[] Store(int n) {
        int temp = n;
        int cnt = 0;
        while (temp > 0) {
            cnt++;
            temp /= 10;
        }
        String[] arr = new String[cnt];
        int index = cnt - 1;
        while (n > 0) {
            arr[index] = String.valueOf(n % 10);
            n /= 10;
            index--;
        }
        return arr;
    }
	public static String[] Reversed(String []Digits) {
		String[] rev= new String[Digits.length];
        for (int i = 0; i < Digits.length; i++) {
            rev[i] = Digits[Digits.length-1-i];
        }
        return rev;
	}
	public static boolean check(String[] Digits,String []rev) {
		if(Digits.length!=rev.length) {
			return false;
		}
		for(int i=0;i<Digits.length;i++) {
			if(!Digits[i].equals(rev[i])) {
				return false;
			}
		}
		return true;
	}
	 public static boolean CheckDuck(String[] arr) {
	        for (int i = 1; i < arr.length; i++) {
	            if (arr[i].equals("0")) {
	                return true;
	            }
	        }
	        return false;
	    }
}
