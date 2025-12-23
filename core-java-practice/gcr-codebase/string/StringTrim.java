import java.util.*;
public class StringTrim {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String Str=sc.nextLine();
		int []IndexWithTrimmed=get(Str);
		String SubstringUsingCharAt=UsingCharAt(Str,IndexWithTrimmed[0],IndexWithTrimmed[1]);
		String BuiltInTrimmed=Str.trim();
		System.out.println("String Trimmed Using CharAt:"+SubstringUsingCharAt);
		System.out.println("String Trimmed Using BuiltIn:"+BuiltInTrimmed);
		if(check(SubstringUsingCharAt,BuiltInTrimmed)) {
			System.out.println("Both Strings are Equal");
		}
		else {
			System.out.println("Both Strings are not Equal");
		}
		sc.close();
	}
	public static int[] get(String str) {
		int start=0;
		int end=str.length()-1;
		while(start<=end && str.charAt(start)==' ') {
			start++;
		}
		while(end>=start&& str.charAt(end)==' ') {
			end--;
		}
		int []idx= {start,end};
		return idx;
	}
	public static String UsingCharAt(String str,int start,int end) {
		String ans="";
		for(int i=start;i<=end;i++) {
			ans+=str.charAt(i);
		}
		return ans;
	}
	public static boolean check(String str1,String str2) {
		if(str1.length()!=str2.length()) {
			return false;
		}
		else {
			for(int i=0;i<str1.length();i++) {
				if(str1.charAt(i)!=str2.charAt(i)) {
					return false;
				}
			}
		}
		return true;
	}

}
