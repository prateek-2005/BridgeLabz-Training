import java.util.*;
public class BMI {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double WeightInKg=sc.nextDouble();
		double HeightInCm=sc.nextDouble();
		double HeightInMeters=HeightInCm/100;
		double bmi=WeightInKg/ (HeightInMeters*HeightInMeters);
		if(bmi<=18.4) {
			System.out.println("UnderWeight");
		}
		else if(bmi>=18.5 && bmi<=24.9) {
			System.out.println("Normal");
		}
		else if(bmi>=25.0 && bmi<=39.9) {
			System.out.println("OverWeight");
		}
		else {
			System.out.println("Obese");
		}
		sc.close();
	}

}
