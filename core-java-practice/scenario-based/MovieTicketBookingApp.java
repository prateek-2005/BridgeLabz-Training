import java.util.*;

public class MovieTicketBookingApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int NumberOfCustomers = sc.nextInt();
		for (int i = 0; i < NumberOfCustomers; i++) {
			BookTicket(i);
		}
	}

	public static void BookTicket(int i) {
		System.out.println("Movie Choice Types: 1.Action 2.Drama 3.Horror 4.Comedy");
		System.out.println("Enter Movie Choice: ");
		int Choice = sc.nextInt();
		String MovieType;
		switch (Choice) {
		case 1:
			MovieType = "Action";
			break;
		case 2:
			MovieType = "Drama";
			break;
		case 3:
			MovieType = "Horror";
			break;
		case 4:
			MovieType = "Comedy";
			break;
		default:
			return;
		}
		System.out.println("Seat Choice Types: 1.Platinum 2.Gold 3.Silver 4.Bronze");
		System.out.println("Enter Seat Choice: ");
		int SeatChoice = sc.nextInt();
		String SeatTypes;
		switch (SeatChoice) {
		case 1:
			SeatTypes = "Platinum";
			break;
		case 2:
			SeatTypes = "Gold";
			break;
		case 3:
			SeatTypes = "Silver";
			break;
		case 4:
			SeatTypes = "Bronze";
			break;
		default:
			return;
		}
		System.out.println("Opted For Snacks: 1.Yes 2.No");
		int SnacksOpted=sc.nextInt();
		String Opted=SnacksOpted==1?"Yes":"No";
		System.out.println();
		System.out.println("Booking Details For Customer "+i);
		System.out.println("Movie Type: "+MovieType);
		System.out.println("Seat Type: "+SeatTypes);
		System.out.println("Snacks Opted: "+Opted);
		
	}

}
