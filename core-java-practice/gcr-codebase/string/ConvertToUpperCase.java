import java.util.*;
public class ConvertToUpperCase {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		String UpperCaseCharAt=get(str);
		String UpperCaseBuiltin=str.toUpperCase();
		System.out.println("UsingBuiltin:  "+UpperCaseBuiltin);
		if(check(UpperCaseCharAt,UpperCaseBuiltin)) {
			System.out.println("Both strings are equal.");
        } else {
            System.out.println("Strings are not equal.");
        }
		sc.close();
	}
	public static String get(String s) {
		String ans="";
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char)(ch - 32);
            }
            ans+= ch;
		}
		System.out.println("Using CharAt:  "+ans);
		return ans;
	}
	public static boolean check(String UpperCaseCharAt,String UpperCaseBuiltin) {
		if(UpperCaseCharAt.length()!=UpperCaseBuiltin.length()) {
			return false;
		}
		else {
			for(int i=0;i<UpperCaseCharAt.length();i++) {
				if(UpperCaseCharAt.charAt(i)!=UpperCaseBuiltin.charAt(i)) {
					return false;
				}
			}
		}
		return true;
	}
}
