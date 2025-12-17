import java.util.*;

public class SimpleInterest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long p=sc.nextLong();
        long r=sc.nextLong();
        int t=sc.nextInt();
        long si=(long)(p*r*t/100);
        System.out.println(si);
    }
}
