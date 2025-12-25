import java.util.*;
public class Trigonometric {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double angle=sc.nextDouble();
		double []ans=find(angle);
		System.out.println("Sine Value: "+ans[0]);
		System.out.println("Cosine Value: "+ans[1]);
		System.out.println("Tangent value: "+ans[1]);
		sc.close();
	}
	public static double[] find(double angle) {
		double radian= Math.toRadians(angle);
        double sin = Math.sin(radian);
        double cos = Math.cos(radian);
        double tan = Math.tan(radian);
        return new double[]{sin,cos,tan};
	}
}
