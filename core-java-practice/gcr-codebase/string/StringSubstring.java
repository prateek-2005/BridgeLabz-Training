import java.util.*;
public class StringSubstring {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String Str=sc.next();
		int start=sc.nextInt();
		int end=sc.nextInt();
		String Substring1=SubstringusingCharAt(Str,start,end);
		String Substring2=SubstringUsingInbuilt(Str,start,end);
		if(Substring1.equals(Substring2)) {
			System.out.println("Both substrings are equal");
		}
		else {
			System.out.println("Both substrings are not equal");
		}
		sc.close();
	}
	public static String SubstringusingCharAt(String Str,int start ,int end) {
		String Ans="";
		for(int i=start;i<end;i++) {
			Ans+=Str.charAt(i);
		}
		System.out.println(Ans);
		return Ans;
	}
	public static String SubstringUsingInbuilt(String Str,int start ,int end) {
		System.out.println(Str.substring(start,end));
		return Str.substring(start,end);
	}

}
