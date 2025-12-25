import java.util.*;
public class ChocolateDistribution {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int NumberOfChocolates=sc.nextInt();
		int NumberOfChildren=sc.nextInt();
		int []ans=find(NumberOfChocolates,NumberOfChildren);
		System.out.println("Number Of Chocolates Each Child Gets: "+ans[0]);
		System.out.println("Number Of Remaining Chocolates:  "+ans[1]);
		sc.close();
	}
	public static int[] find(int NumberOfChocolates,int NumberOfChildren) {
		int Gets=NumberOfChocolates/NumberOfChildren;
		int remaining=NumberOfChocolates%NumberOfChildren;
		return new int[] {Gets,remaining};
	}
}
