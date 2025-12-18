import java.util.*;
public class BasicCalculator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double a=sc.nextDouble();
        double b=sc.nextDouble();
        double addition=a+b;
        double subtraction=a-b;
        double multilply=a*b;
        double divison=a/b;
        System.out.println(" The addition, subtraction, multiplication and division value of 2 numbers "+a+" and "+b+" is "+addition+","+subtraction+","+multilply+" and "+divison);
    }
}
