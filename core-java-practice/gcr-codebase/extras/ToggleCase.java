import java.util.*;
public class ToggleCase {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String Str=sc.next();
		System.out.println("Original String: "+Str);
		String New=Toggle(Str);
		System.out.println("Modified String: "+New);
		sc.close();
	}
	public static String Toggle(String Str) {
		String ans="";
		for(int i=0;i<Str.length();i++) {
			char ch=Str.charAt(i);
			if(ch>=65 && ch<=90) {
				ans+=(char)(ch+32);
			}
			else {
				ans+=(char)(ch-32);
			}
		}
		return ans;
	}
}
