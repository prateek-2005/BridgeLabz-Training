import java.util.*;
public class DistanceandLine {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Co-Ordinates of the points");
		int x1=sc.nextInt();
		int y1=sc.nextInt();
		int x2=sc.nextInt();
		int y2=sc.nextInt();
		double distance=Distance(x1,y1,x2,y2);
		System.out.println("Euclidean Distance: "+distance);
		double []line=find(x1,y1,x2,y2);
		System.out.println("Slope:"+line[0]+" And Intercept:"+line[1]);
		sc.close();
	}
	public static double Distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
	public static double[] find(double x1, double y1, double x2, double y2) {
        double[] arr= new double[2]; 
        if (x2 == x1) {
            System.out.println("Vertical line detected: Equation is x = " + x1);
            arr[0] = Double.POSITIVE_INFINITY;
            arr[1] = Double.NaN;              
        } else {
            double slope = (y2 - y1) / (x2 - x1);
            double intercept = y1 - slope * x1;
            arr[0] = slope;
            arr[1] = intercept;
        }

        return arr;
    }

}
