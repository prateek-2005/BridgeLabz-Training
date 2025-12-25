import java.util.*;
public class WindChill {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double temperature=sc.nextDouble();
		double WindSpeed=sc.nextDouble();
		System.out.println("Wind Chill Temperature:  "+find(temperature,WindSpeed));
		sc.close();
	}
	public static double find(double temperature,double WindSpeed) {
		double windchill=(double)(35.74+0.6215*temperature+(0.4275*temperature-35.75)*Math.pow(WindSpeed,0.16));
		return windchill;
	}
}
