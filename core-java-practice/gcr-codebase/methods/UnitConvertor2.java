import java.util.*;
public class UnitConvertor2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double yards=sc.nextDouble();
		double FeetCalculated=convertYardsToFeet(yards);
		double YardsCalculated=convertFeetToYards(FeetCalculated);
		double meters=yards*0.9144;
		double InchesCalculated=convertMetersToInches(meters);
		double MetersCalculated=convertInchesToMeters(InchesCalculated);
		double CmCalculated=convertInchesToCm(InchesCalculated);
		System.out.println("Feet:"+FeetCalculated);
		System.out.println("Yards:"+YardsCalculated);
		System.out.println("Inches:"+InchesCalculated);
		System.out.println("Meters:"+MetersCalculated);
		System.out.println("CentiMeters:"+CmCalculated);
		sc.close();
	}
	public static double convertYardsToFeet(double Yards) {
		double yards2feet = 3;
		return (double)(Yards*yards2feet);
	}
	public static double convertFeetToYards(double feet) {
		double feet2yards = 0.333333;
		return (double)(feet*feet2yards);
	}
	public static double convertMetersToInches(double m) {
		double meters2inches = 39.3701;
		return (double)(m*meters2inches);
	}
	public static double convertInchesToMeters(double i) {
		double inches2meters = 0.0254;
		return (double)(i*inches2meters);
	}
	public static double convertInchesToCm(double i) {
		double inches2cm = 2.54;
		return (double)(i*inches2cm);
	}
}
