import java.util.*;
public class BMIMethod {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double [][]bmi=new double[10][3];
		for(int i=0;i<10;i++) {
			System.out.println("Enter Weight In Kg:");
			bmi[i][0]=sc.nextDouble();
			System.out.println("Enter Height In CM:");
			bmi[i][1]=sc.nextDouble();
			bmi[i][2]=Calculate(bmi[i][0],bmi[i][1]);
		}
		String []Status=new String[10];
		for(int i=0;i<10;i++) {
			Status[i]=Category(bmi[i][2]);
		}
		System.out.println("Weight\t\tHeight\t\tBMI\t\t\tCategory");
		for(int i=0;i<10;i++) {
			System.out.println(bmi[i][0]+"\t\t"+bmi[i][1]+"\t\t"+bmi[i][2]+"\t\t"+Status[i]);
		}
		sc.close();
	}
	public static double Calculate(double Kg,double Height) {
		double HeightInM=Height/100.0;
		return (double)(Kg/(HeightInM*HeightInM));
	}
	public static String Category(double bmi) {
		if (bmi <= 18.4) {
            return "Underweight";
        } else if (bmi>=18.5 && bmi<=24.9) {
        	return "Normal";
        } else if (bmi>=25 && bmi<=39.9) {
        	return "Overweight";
        } else {
        	return "Obese";
        }
	}
}
