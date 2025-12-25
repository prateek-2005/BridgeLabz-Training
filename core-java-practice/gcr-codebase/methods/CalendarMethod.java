import java.util.Scanner;
public class CalendarMethod {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int month=sc.nextInt();
		int year=sc.nextInt();
		System.out.println("\n   " +MonthName(month)+ " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        int firstday=FirstDay(month,year);
        int daysinmonth=DaysInMonth(month,year);
        for (int i = 0; i < firstday; i++) {
            System.out.print("    ");
        }
        for (int i= 1;i<=daysinmonth;i++) {
            System.out.printf("%3d ",i);
            if ((i+firstday) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        sc.close();
	}
	public static String MonthName(int n) {
		String[] months = {"January", "February", "March", "April", "May", "June","July", "August", "September", "October", "November", "December"};
		return months[n-1];
	}
	public static int DaysInMonth(int month, int year) {
        int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (month == 2 && check(year)) {
            return 29;
        }
        return days[month - 1];
    }
	public static boolean check(int year) {
		return (year%400==0) || (year % 4 == 0 && year % 100 != 0);
	}
	static int FirstDay(int month, int year) {
        int d = 1;
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;
        return d0;
    }
}
