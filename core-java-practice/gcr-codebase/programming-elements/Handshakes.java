import java.util.*;
public class Handshakes {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int possible=(n*(n-1))/2;
        System.out.println("The number of possible handshakes is "+possible);
    }
}
