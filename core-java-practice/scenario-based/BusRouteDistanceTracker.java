import java.util.Scanner;

public class BusRouteDistanceTracker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean check= true;
		int TotalDistance=0;
		while(check) {
			TotalDistance+=10;
			System.out.println("do you want to get off at this stop(enter yes or no)");
			String Exit= sc.next();
			if(Exit.equalsIgnoreCase("yes")) {
				check= false;
			}
		}
		System.out.println("Total distance Travelled: "+TotalDistance);
		sc.close();
	}
}