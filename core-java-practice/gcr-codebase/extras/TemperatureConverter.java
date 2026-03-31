import java.util.*;
public class TemperatureConverter {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Temperature In Farhenheit:");
		double Farhenheit=sc.nextDouble();
		double CelsiusCalculated=ConvertFarhenheitToCelsius(Farhenheit);
		double FarhenheitCalculated=ConvertCelsiusToFarhenheit(CelsiusCalculated);
		System.out.println("Farhenheit To Celsius: "+CelsiusCalculated);
		System.out.println("Celsius To Farhenheit: "+FarhenheitCalculated);
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
}
