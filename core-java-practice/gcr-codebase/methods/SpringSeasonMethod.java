import java.util.*;
public class SpringSeasonMethod {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int day=sc.nextInt();
		int month=sc.nextInt();
		if(check(day,month)) {
			System.out.println("Its a Spring Season");
		}
		else {
			System.out.println("Not a Spring Season");
		}
		sc.close();
	}
	public static boolean check(int day,int month) {
		if((month==3 && day>=20) || month==4 || month==5 || (month==6 && day<=20)) {
			return true;
		}
		else {
			return false;
		}
	}
}
