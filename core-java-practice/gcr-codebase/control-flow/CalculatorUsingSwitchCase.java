import java.util.*;
public class CalculatorUsingSwitchCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        double first = sc.nextDouble();
        double second = sc.nextDouble();
        String operator = sc.next();
        switch(operator) {
        	case "+":
        		double addition=first+second;
        		System.out.println("Addition of two numbers " +first+" and "+second+" is "+addition);
        		break;
        	case "-":
        		double subtraction=first-second;
        		System.out.println("Subtraction of two numbers " +first+" and "+second+" is "+subtraction);
        		break;
        	case "*":
        		double multiplication=first*second;
        		System.out.println("Multiplication of two numbers " +first+" and "+second+" is "+multiplication);
        		break;
        	case "/":
        		double divison=first/second;
        		System.out.println("Divison of two numbers " +first+" and "+second+" is "+divison);
        		break;
        	default:
                System.out.println("Invalid Operator");
        }
        sc.close();
	}

}
