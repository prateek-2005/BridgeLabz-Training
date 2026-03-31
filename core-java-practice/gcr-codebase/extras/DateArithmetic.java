import java.time.LocalDate;
import java.util.*;
public class DateArithmetic {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Year:");
		int year=sc.nextInt();
		System.out.println("Month:");
		int month=sc.nextInt();
		System.out.println("Day:");
		int day=sc.nextInt();
		LocalDate date=LocalDate.of(year, month, day);
		LocalDate ans=date.plusDays(7).plusMonths(1).plusYears(2).minusWeeks(3);
		System.out.println("After Arithmetic: "+ans);
		sc.close();
	}

}
