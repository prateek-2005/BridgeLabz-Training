import java.util.*;
public class SmallestAndLargestMethod {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num1=sc.nextInt();
		int num2=sc.nextInt();
		int num3=sc.nextInt();
		int []ans=findLargestAndSmallest(num1,num2,num3);
		System.out.println("Largest Number: "+ans[0]);
		System.out.println("Smallest Number: "+ans[1]);
		sc.close();
	}
	public static int[] findLargestAndSmallest(int num1,int num2,int num3) {
		int largest=0;
		int smallest=0;
		if(num1>=num2 && num1>=num3) {
			largest=num1;
		}
		else if(num2>=num1 && num2>=num3) {
			largest=num2;
		}
		else {
			largest=num3;
		}
		if(num1<=num2 && num1<=num3) {
			smallest=num1;
		}
		else if(num2<=num1 && num2<=num3) {
			smallest=num2;
		}
		else {
			smallest=num3;
		}
		return new int[] {largest,smallest};
	}

}
