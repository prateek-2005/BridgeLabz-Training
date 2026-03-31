import java.util.*;
public class BMIArray {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int []weight=new int[n];
		double []height=new double[n];
		double []bmi=new double[n];
		String []category=new String[n];
		System.out.println("Enter Weight");
		for(int i=0;i<n;i++) {
			weight[i]=sc.nextInt();
		}
		System.out.println("Enter Height");
		for(int i=0;i<n;i++) {
			height[i]=sc.nextDouble();
		}
		for(int i=0;i<n;i++) {
			bmi[i]=weight[i]/height[i];
		}
		for(int i=0;i<n;i++) {
			double temp=bmi[i];
			if(temp<=18.4) {
				category[i]="UnderWeight";
			}
			else if(temp>=18.5 && temp<=24.9) {
				category[i]="Normal";
			}
			else if(temp>=25.0 && temp<=39.9) {
				category[i]="OverWeight";
			}
			else {
				category[i]="Obese";
			}
		}
		System.out.println("Weight(kg) Height(M) BMI Category");
		for(int i=0;i<n;i++) {
			System.out.println(weight[i]+" "+height[i]+" "+bmi[i]+" "+category[i]);
		}
		sc.close();
	}

}
