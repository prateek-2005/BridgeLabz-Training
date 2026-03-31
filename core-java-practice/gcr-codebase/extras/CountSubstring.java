import java.util.*;
public class CountSubstring {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String Str=sc.nextLine();
		String Sub=sc.next();
		System.out.println("Original String: "+Str);
		System.out.println("Substring: "+Sub);
		int count=Count(Str,Sub);
		System.out.println("Number Of Occurences of Substring: "+count);
		sc.close();
	}
	public static int Count(String Str,String Sub) {
		int count = 0;
	    int n = Str.length();
	    int m = Sub.length();
	    for (int i=0;i<=n-m;i++){
	        String temp= Str.substring(i, i + m);
	        if (temp.equals(Sub)) {
	            count++;
	        }
	    }
	    return count;

	}
}
