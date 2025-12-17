import java.util.*;
public class Factorial {
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();//Taking input
        System.out.println(fact(n));//Print Output
    }
    //Recursive Apporach
    public static int fact(int n){
        //Base Condition
        if(n==0 || n==1){
            return 1;
        }
        //Return Statement
        return n*fact(n-1);
    }
}
