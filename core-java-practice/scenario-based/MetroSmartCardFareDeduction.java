import java.util.*;
public class MetroSmartCardFareDeduction {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Metro");
		int balance = 50;
		boolean flag = true;
		while (flag) {
			System.out.println("Your current balance is: " + balance);
			System.out.println("Enter distance in km(Enter -1 To Exit): ");
			int distance = sc.nextInt();
			if (distance < 0) {
				System.out.println("Thank you for using Metro");
				break;
			}
			
			int fare = (distance <= 10) ?25:(distance <= 30) ? 40:50;
			System.out.println("Your fare is "+fare+" rupees");
			System.out.println("You want top-up(yes Or no)");
			String topup=sc.next();
			if(topup.equalsIgnoreCase("yes")) {
				System.out.println("Enter Amount To be top-up");
				int amount=sc.nextInt();
				balance+=amount;
			}
			System.out.println("Do You want to continue: 0 for yes and 1 for no");
			int check= sc.nextInt();
			if(check== 0) {
				if (balance >= fare) {
					balance = balance - fare;
					System.out.println("Fare deducted: " + fare);
				}
				else {
					System.out.println("Insufficient balance");
					break;
				}
			}
			else {
				System.out.println("you don't want to continue this ride");
			}
			
		}
		System.out.println("Remaining balance in your smart card is: " + balance);
	}
}