import java.util.*;
public class NumberDivisibleby5 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		if(number%5==0) {
			System.out.println("Yes the number " +number+" divisible by 5");
		}
		else {
			System.out.println("No the number " +number+" is not divisible by 5");
		}
		sc.close();
	}
}
