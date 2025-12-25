import java.util.*;
public class UnitConvertor3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double Farhenheit=sc.nextDouble();
		double CelsiusCalculated=ConvertFarhenheitToCelsius(Farhenheit);
		double FarhenheitCalculated=ConvertCelsiusToFarhenheit(CelsiusCalculated);
		double Pounds=sc.nextDouble();
		double KiloGramsCalculated=ConvertPoundsToKiloGrams(Pounds);
		double PoundsCalculated=ConvertKiloGramsToPounds(KiloGramsCalculated);
		double Gallons=sc.nextDouble();
		double LitresCalculated=ConvertGallonsToLitres(Gallons);
		double GallonsCalculated=ConvertLitresToGallons(LitresCalculated);
		System.out.println("Celsius:"+CelsiusCalculated);
		System.out.println("Farhenheit:"+FarhenheitCalculated);
		System.out.println("KiloGrams:"+KiloGramsCalculated);
		System.out.println("Pounds:"+PoundsCalculated);
		System.out.println("Litres:"+LitresCalculated);
		System.out.println("Gallons:"+GallonsCalculated);
		sc.close();
	}
	public static double ConvertFarhenheitToCelsius(double F) {
		double farhenheit2celsius = (F- 32) * 5 / 9;
		return farhenheit2celsius;
	}
	public static double ConvertCelsiusToFarhenheit(double C) {
		double celsius2farhenheit = (C * 9 / 5) + 32;
		return celsius2farhenheit;
	}
	public static double ConvertPoundsToKiloGrams(double P) {
		double pounds2kilograms = 0.453592;
		return (double)(pounds2kilograms*P);
	}
	public static double ConvertKiloGramsToPounds(double K) {
		double kilograms2pounds = 2.20462;
		return (double)(kilograms2pounds*K);
	}
	public static double ConvertGallonsToLitres(double G) {
		double gallons2liters = 3.78541;
		return (double)(gallons2liters*G);
	}
	public static double ConvertLitresToGallons(double L) {
		double liters2gallons = 0.264172;
		return (double)(liters2gallons*L);
	}
}
