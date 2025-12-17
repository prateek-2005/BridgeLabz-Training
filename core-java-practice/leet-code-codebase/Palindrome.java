import java.util.*;
public class Palindrome {
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();//Taking string as input
        String rev = "";//Empty String
        for (int i = s.length() - 1; i >= 0; i--) {
            rev += s.charAt(i);//append reverse characters to rev
        }
        //output
        if (s.equals(rev))
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }
}
