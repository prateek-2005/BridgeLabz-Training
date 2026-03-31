import java.util.*;
class Circle{
	double Radius;
	Circle(double Radius){
		this.Radius=Radius;
	}
	void CalculateArea() {
		double Area=3.14*Radius*Radius;
		System.out.println("Area Of Circle: "+Area);
	}
	void CalculateCircumference() {
		double Circumference=2*3.14*Radius;
		System.out.println("Circumference Of Circle: "+Circumference);
	}
}
public class AreaOfCircle {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double radius=sc.nextDouble();
		Circle c=new Circle(radius);
		c.CalculateArea();
		c.CalculateCircumference();
		sc.close();
	}

}
