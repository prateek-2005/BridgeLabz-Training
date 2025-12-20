import java.util.*;
public class BMI2D {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		double [][]personData=new double[number][3];
		String []WeightStatus=new String[number];
		for(int i=0;i<number;i++) {
				personData[i][0]=sc.nextDouble();
				personData[i][1]=sc.nextDouble();
				personData[i][2]=personData[i][0]/(personData[i][1]*personData[i][1]);
		}
		for(int i=0;i<number;i++) {
			double temp=personData[i][2];
			if(temp<=18.4) {
				WeightStatus[i]="UnderWeight";
			}
			else if(temp>=18.5 && temp<=24.9) {
				WeightStatus[i]="Normal";
			}
			else if(temp>=25.0 && temp<=39.9) {
				WeightStatus[i]="OverWeight";
			}
			else {
				WeightStatus[i]="Obese";
			}
		}
		System.out.println("Weight(kg) Height(M) BMI Category");
		for(int i=0;i<number;i++) {
			System.out.println(personData[i][0]+"     "+personData[i][1]+"     "+personData[i][2]+"      "+WeightStatus[i]);
		}
		sc.close();
	}

}
