import java.util.*;
public class AreaOfTriangle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double base=sc.nextDouble();
        double height=sc.nextDouble();
        double areaincm=0.5*base*height;
        double areaininches=areaincm/2.54;
        System.out.println("Area of Triangle with base "+base +" and height "+height +" is "+ areaincm+" in sq.cm and "+areaininches+" in sq.cm");
    }
}
