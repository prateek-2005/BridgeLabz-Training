import java.util.*;
public class CheckPallidrome {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String Str=sc.next();
		System.out.println("String: "+Str);
		String Rev=Reverse(Str);
		System.out.println("Reversed String:  "+Rev);
		if(check(Str,Rev)) {
			System.out.println("Pallindrome String");
		}
		else {
			System.out.println("Not Pallindrome String");
		}
		sc.close();
	}
	public static String Reverse(String Str) {
		String ans="";
		for(int i=Str.length()-1;i>=0;i--) {
			ans+=Str.charAt(i);
		}
		return ans;
	}
	public static boolean check(String Str,String Rev) {
		if(Str.length()!=Rev.length()) {
			return false;
		}
		for(int i=0;i<Str.length();i++) {
			if(Str.charAt(i)!=Rev.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}
