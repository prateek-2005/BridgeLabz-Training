import java.util.*;
public class NumberMethod {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int []number=new int[5];
		for(int i=0;i<5;i++) {
			number[i]=sc.nextInt();
		}
		for (int i = 0; i < number.length; i++) {
            if (isPositive(number[i])) {
                if (isEven(number[i])) {
                    System.out.println(number[i] + " is Positive Even Number");
                } else {
                    System.out.println(number[i] + " is Positive Odd Number");
                }
            } else {
                System.out.println(number[i] + " is Negative Number");
            }
        }
		int ans= check(number[0],number[number.length - 1]);
        if (ans==1) {
            System.out.println("First element is greater than last element");
        } else if (ans==0) {
            System.out.println("First element is equal to last element");
        } else {
            System.out.println("First element is less than last element");
        }
        sc.close();
	}
	public static boolean isPositive(int num) {
        return num >= 0;
    }
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
    public static int check(int number1, int number2){
        if (number1 > number2) {
            return 1;
        } else if (number1 == number2) {
            return 0;
        } else {
            return -1;
        }
    }
}
