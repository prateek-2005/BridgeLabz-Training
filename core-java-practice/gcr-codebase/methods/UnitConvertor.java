import java.util.*;
public class UnitConvertor {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double Km=sc.nextDouble();
		double MilesCalculated=convertKmToMiles(Km);
		double KmCalculated=convertMilesToKm(MilesCalculated);
		double Meters=1000*Km;
		double FeetsConverted=convertMetersToFeet(Meters);
		double MetersConverted=convertFeetToMeters(FeetsConverted);
		System.out.println("Miles: "+MilesCalculated);
		System.out.println("KiloMeters: "+KmCalculated);
		System.out.println("Feet: "+FeetsConverted);
		System.out.println("Meters: "+MetersConverted);
		sc.close();
		
	}
	public static double convertKmToMiles(double Km) {
		double km2miles = 0.621371;
		return (double)(Km*km2miles);
	}
	public static double convertMilesToKm(double Miles) {
		double miles2km = 1.60934;
		return (double)(Miles*miles2km);
	}
	public static double convertMetersToFeet(double M) {
		double meters2feet = 3.28084;
		return (double)(M*meters2feet);
	}
	public static double convertFeetToMeters(double F) {
		double feet2meters = 0.3048;
		return (double)(F*feet2meters);
	}
}
