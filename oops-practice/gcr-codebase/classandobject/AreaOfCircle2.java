import java.util.Scanner;
class Circle{
	double Radius;
	//Default Constructor
	Circle(){
		this.Radius=1;
	}
	//Parameterized Constructor
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
public class AreaOfCircle2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double radius=sc.nextDouble();
		Circle c1=new Circle();
		System.out.println("Radius Of Circle: "+ c1.Radius);
		c1.CalculateArea();
		c1.CalculateCircumference();
		System.out.println();
		Circle c=new Circle(radius);
		System.out.println("Radius Of Circle: "+ c.Radius);
		c.CalculateArea();
		c.CalculateCircumference();
		sc.close();
	}

}
