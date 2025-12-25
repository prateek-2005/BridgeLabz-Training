import java.util.*;
public class PositiveNeagtiveAndZero {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println("Number Type:"+check(n));
		sc.close();
	}
	public static int check(int n) {
		if(n<0) {
			return -1;//Number is Negative
		}
		else if(n==0) {
			return 0;//Number is Zero
		}
		else {
			return 1;//Number is Positive
		}
	}
}
