import java.util.*;
public class ReverseAString {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String Str=sc.next();
		System.out.println("String: "+Str);
		String Rev=Reverse(Str);
		System.out.println("Reversed String:  "+Rev);
		sc.close();
	}
	public static String Reverse(String Str) {
		String ans="";
		for(int i=Str.length()-1;i>=0;i--) {
			ans+=Str.charAt(i);
		}
		return ans;
	}
}
