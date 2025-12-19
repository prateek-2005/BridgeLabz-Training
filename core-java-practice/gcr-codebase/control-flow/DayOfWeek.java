import java.util.*;
public class DayOfWeek {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int month=sc.nextInt();
		int day=sc.nextInt();
		int year=sc.nextInt();
		int y0 = year - (14 - month) / 12;
	    int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
	    int m0 = month + 12 * ((14 - month) / 12) - 2;
	    int d0 = (day + x + (31 * m0) / 12) % 7;
	    System.out.println(d0);
	    sc.close();
	}

}
