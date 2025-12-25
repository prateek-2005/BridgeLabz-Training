import java.util.*;
public class QuadraticEquation {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Cofficients Of The Quadratic Equations:");
		double a=sc.nextDouble();
		double b=sc.nextDouble();
		double c=sc.nextDouble();
		double []roots=find(a,b,c);
		if(roots.length==2) {
			System.out.println("Roots Of The Equations are: "+roots[0]+","+roots[2]);
		}
		else if(roots.length==1) {
			System.out.println("Only one Roots:"+roots[0]);
		}
		else {
			System.out.println("No Roots Possible");
		}
		sc.close();
	}
	public static double[] find(double a,double b,double c) {
		double delta = Math.pow(b, 2) - 4 * a * c;
        if (delta > 0) {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[]{root1, root2};
        } else if (delta == 0) {
            double root = -b / (2 * a);
            return new double[]{root};
        } else {
            return new double[]{}; 
        }

	}
}
