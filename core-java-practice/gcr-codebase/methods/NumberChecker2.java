import java.util.*;

public class NumberChecker2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] Digits = Store(n);
        System.out.println("Count Of Digits In Number: " + Digits.length);
        System.out.println("Digits in number:");
        for (String d : Digits) {
            System.out.print(d + " ");
        }
        System.out.println();
        System.out.println("Sum Of Digits: "+SumOfDigits(Digits));
        System.out.println("Sum Of Square Of Digits: "+SumOfSquareOfDigits(Digits));
        if(check(n,Digits)) {
        	System.out.println(n+"is a Harshad Number");
        }
        else {
        	System.out.println(n+"is not a Harshad Number");
        }
        int [][]freq=Frequency(n);
        System.out.println("Frequency Of Digits in number");
        for(int i=0;i<freq.length;i++) {
        	System.out.println(freq[i][0]+" "+freq[i][1]);
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
	public static int SumOfDigits(String[] Digits) {
		int sum=0;
		for(String d:Digits) {
			sum+=Integer.parseInt(d);
		}
		return sum;
	}
	public static int SumOfSquareOfDigits(String[] Digits) {
		int sum=0;
		for(String d:Digits) {
			sum+=Math.pow(Integer.parseInt(d),2);
		}
		return sum;
	}
	public static boolean check(int n,String[] Digits) {
		int sum=0;
		for(String d:Digits) {
			sum+=Integer.parseInt(d);
		}
		return n%sum==0;
	}
	public static int[][] Frequency(int n) {
	    int[][] freq = new int[10][2];
	    for (int i = 0; i < 10; i++) {
	        freq[i][0] = i;  
	        freq[i][1] = 0; 
	    }
	    String Str= String.valueOf(n);
	    for (int i = 0; i < Str.length(); i++) {
	        int digit =Integer.parseInt(String.valueOf(Str.charAt(i)));
	        freq[digit][1]++;
	    }

	    return freq;
	}
}
