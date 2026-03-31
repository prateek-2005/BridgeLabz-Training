import java.util.*;
public class LeapYearMethod {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int year=sc.nextInt();
		if(check(year)) {
			System.out.println(year+" is a Leap Year");
		}
		else {
			System.out.println(year+" is Not a Leap Year");
		}
		sc.close();
	}
	public static boolean check(int year) {
		if(year<1582) {
			return false;
		}
		return (year%400==0 || (year%4==0 && year %100!=0));
	}
}
