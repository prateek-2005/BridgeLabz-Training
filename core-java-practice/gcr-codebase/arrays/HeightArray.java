import java.util.*;
public class HeightArray {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double []height=new double[11];
		for(int i=0;i<11;i++) {
			height[i]=sc.nextDouble();
		}
		double TotalHeight=0;
		for(int i=0;i<11;i++) {
			TotalHeight+=height[i];
		}
		double MeanHeight=TotalHeight/11;
		System.out.println("The mean height of the football team is "+MeanHeight);
		sc.close();
	}

}
