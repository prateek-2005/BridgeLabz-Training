import java.util.*;
public class NumberOfRounds {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double Side1=sc.nextDouble();
		double Side2=sc.nextDouble();
		double Side3=sc.nextDouble();
		double Perimeter=Side1+Side2+Side3;
		double DistanceInMeters=5000;
		System.out.println("the number of rounds user needs to do to complete 5km run "+find(Perimeter,DistanceInMeters));
		sc.close();
	}
	public static double find(double Perimeter,double DistanceInMeters) {
		return Math.ceil(DistanceInMeters/Perimeter);
	}
}
