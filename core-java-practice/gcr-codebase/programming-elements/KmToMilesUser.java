import java.util.*;
public class KmToMilesUser {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double km=sc.nextDouble();
        double miles=((double) km*1.6);
        System.out.println("The total miles is "+miles+" mile for the given "+km+"km");
    }
}
