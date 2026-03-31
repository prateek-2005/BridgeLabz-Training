import java.util.*;
public class SimpleInterestMethod {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double Principal=sc.nextDouble();
		double Rate=sc.nextDouble();
		double Time=sc.nextDouble();
		System.out.println("The Simple Interest is "+SimpleInterest(Principal,Rate,Time)+" for Principal "+
		                   Principal+" Rate of Interest "+Rate+" and time "+Time);
		sc.close();
	}
	public static double SimpleInterest(double Principal,double Rate,double Time) {
		return (double)(Principal*Rate*Time)/100.0;
	}
}
