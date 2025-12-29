import java.util.*;
public class FestivalLuckyDraw {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 1 to start the game");
		int n=sc.nextInt();
		//Enter 0 to exit the game
		while(n!=0) {
			System.out.println("Draw a number(if you want to exit then enter 0): ");
			n= sc.nextInt();
			if(n<0) {
				System.out.println("Invalid Number,Try Again");
				continue;
			}
			if(n== 0) {
				break;
			}
			if(n%3==0 &&n%5==0) {
				System.out.println("Congrualtions you won the gift");
			}
			else {
				System.out.println("Sorry,Try Again!!!!");
			}
		}
		System.out.println("Thank You,Please Visit Again");
		sc.close();
	}

}
