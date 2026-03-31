import java.util.*;
public class AmarAkbarAnthonyArray {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int []age=new int[3];
		int []height=new int[3];
		System.out.println("Enter age of three: ");
		for(int i=0;i<3;i++) {
			age[i]=sc.nextInt();
		}
		System.out.println("Enter Height of three: ");
		for(int i=0;i<3;i++) {
			height[i]=sc.nextInt();
		}
		if(age[0]<=age[1] && age[0]<=age[2]) {
			System.out.println("Youngest friend is Amar with age "+age[0]);
		}
		else if(age[1]<=age[2] && age[1]<=age[0]) {
			System.out.println("Youngest friend is Akbar with age "+age[1]);
		}
		else {
			System.out.println("Youngest friend is Anthony with age "+age[2]);
		}
		if(height[0]>=height[1] && height[0]>=height[2]) {
			System.out.println("tallest friend is Amar with height "+height[0]);
		}
		else if(height[1]>=height[2] && height[1]>=height[0]) {
			System.out.println("tallest friend is Akbar with height "+height[1]);
		}
		else {
			System.out.println("tallest friend is Anthony with height "+height[2]);
		}
		sc.close();
	}

}
