import java.util.*;
import java.time.LocalDate;
public class DateComparison {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("First Date:");
		String str1=sc.next();
		System.out.println("Second Date:");
		String str2=sc.next();
		LocalDate date1=LocalDate.parse(str1);
		LocalDate date2=LocalDate.parse(str2);
		if(date1.isBefore(date2)) {
			System.out.println("The first date is before second date");
		}
		else if(date1.isAfter(date2)) {
			System.out.println("The first date is after second date");
		}
		else if(date1.isEqual(date2)) {
			System.out.println("The first date is equal second date");
		}
		sc.close();
	}

}
