//import java.util.*;
public class PlayersHeight {

	public static void main(String[] args) {
		System.out.println("Players Height In Centimeters: ");
		int []height=new int[11];
		for(int i=0;i<11;i++) {
			height[i] = (int)(Math.random() * 101) + 150;
		}
		for(int i=0;i<11;i++) {
			System.out.print(height[i]+" ");
		}
		int sum=Sum(height);
		double mean=Mean(sum);
		int minimum=Mini(height);
		int maximum=Maxi(height);
		System.out.println();
		System.out.println("Sum Of Heights: "+sum);
		System.out.println("Mean Height:  "+mean);
		System.out.println("Minimum Height: "+minimum);
		System.out.println("Maximum Height: "+maximum);
	}
	public static int Sum(int []height) {
		int sum=0;
		for(int i=0;i<11;i++) {
			sum+=height[i];
		}
		return sum;
	}
	public static double Mean(int sum) {
		return (double)(sum/11);
	}
	public static int Mini(int []height) {
		int ans=height[0];
		for(int i=1;i<11;i++) {
			ans=Math.min(ans,height[i]);
		}
		return ans;
	}
	public static int Maxi(int []height) {
		int ans=height[0];
		for(int i=1;i<11;i++) {
			ans=Math.max(ans,height[i]);
		}
		return ans;
	}
}
