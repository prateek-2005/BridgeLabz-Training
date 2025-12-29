import java.util.*;
public class BasicCalculator {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 1st Number:");
		int Number1 = sc.nextInt();
		System.out.println("Enter 2nd Number:");
		int Number2 = sc.nextInt();
		String Operator=sc.next();
		switch(Operator) {
    	case "+":
    		double addition=Add(Number1,Number2);
    		System.out.println("Addition of two numbers " +addition);
    		break;
    	case "-":
    		double subtraction=Subtract(Number1,Number2);
    		System.out.println("Subtraction of two numbers " +subtraction);
    		break;
    	case "*":
    		double multiplication=Multiply(Number1,Number2);
    		System.out.println("Multiplication of two numbers " +multiplication);
    		break;
    	case "/":
    		double divison=Divison(Number1,Number2);
    		System.out.println("Divison of two numbers " +divison);
    		break;
    	default:
            System.out.println("Invalid Operator");
		}
	}
	public static int Add(int num1,int num2) {
		return num1+num2;
	}
	public static int Subtract(int num1,int num2) {
		return num1-num2;
	}
	public static int Multiply(int num1,int num2) {
		return num1*num2;
	}
	public static int Divison(int num1,int num2) {
		return num1/num2;
	}
}
