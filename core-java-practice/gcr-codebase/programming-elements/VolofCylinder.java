import java.util.*;
public class VolofCylinder {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long r=sc.nextLong();
        long h=sc.nextLong();
        long volume=(long)((3.14*r*r)*h);
        System.out.println(volume);
    }
}
