import java.util.*;
public class PalindromeChecker {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String:");
		String Str=sc.next();
		String Reversed=Reverse(Str);
		print(Str,Reversed);
		sc.close();
	}
	public static void print(String Str,String Reversed) {
		if(check(Str,Reversed)) {
			System.out.println(Str+" is a pallindrome String");
		}
		else {
			System.out.println(Str+"is not a pallindrome String");
		}
	}
	public static String Reverse(String Str) {
		String ans="";
		char []arr=Str.toCharArray();
		for(int i=arr.length-1;i>=0;i--) {
			ans+=arr[i];
		}
		return ans;
	}
	public static boolean check(String Str,String Reversed) {
		if(Str.length()!=Reversed.length()) {
			return false;
		}
		for(int i=0;i<Str.length();i++) {
			if(Str.charAt(i)!=Reversed.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}
