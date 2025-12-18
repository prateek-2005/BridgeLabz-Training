import java.util.*;
public class QuotientAndRemainder {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nums1=sc.nextInt();
        int nums2=sc.nextInt();
        int remainder =nums1%nums2;
        int quotient=nums1/nums2;
        System.out.println("The Quotient is "+quotient+" and Remainder is "+remainder+" of two number "+nums1+" and "+nums2);
    }
}
