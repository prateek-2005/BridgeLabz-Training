import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.*;
import java.util.*;
public class LibraryReminderApp {
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		for(int i=0;i<5;i++) {
			Issue();
		}
	}
	public static void Issue() {
		System.out.println("Enter Issue Date");
		System.out.println("Year:");
		int year=sc.nextInt();
		System.out.println("Month:");
		int month=sc.nextInt();
		System.out.println("Day:");
		int day=sc.nextInt();
		LocalDate IssuedDate=LocalDate.of(year, month, day);
		System.out.println("Enter Return Days As Per Rule(In Days)");
		int Days=sc.nextInt();
		LocalDate OfficialReturnedDate=IssuedDate.plusDays(Days);
		System.out.println();
		System.out.println("Enter Returned Date");
		System.out.println("Year:");
		int Ryear=sc.nextInt();
		System.out.println("Month:");
		int Rmonth=sc.nextInt();
		System.out.println("Day:");
		int Rday=sc.nextInt();
		LocalDate ReturnedDate=LocalDate.of(Ryear, Rmonth, Rday);
		if(ReturnedDate.isAfter(OfficialReturnedDate)) {
			long lateDays = ChronoUnit.DAYS.between(OfficialReturnedDate, ReturnedDate);
            int fine = (int) lateDays * 5;
            System.out.println();
			System.out.println("Issued Date: "+IssuedDate);
			System.out.println("Returned Date: "+ReturnedDate);
			System.out.println("Fine Amount: "+fine);
		}
		else {
			System.out.println();
			System.out.println("Issued Date: "+IssuedDate);
			System.out.println("Returned Date: "+ReturnedDate);
			System.out.println("Fine Amount: "+0);
		}
	}
}
