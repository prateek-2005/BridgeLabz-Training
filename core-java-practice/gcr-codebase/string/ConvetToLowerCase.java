import java.util.*;
public class ConvetToLowerCase {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		String LowerCaseCharAt=get(str);
		String LowerCaseBuiltin=str.toLowerCase();
		System.out.println("UsingBuiltin:  "+LowerCaseBuiltin);
		if(check(LowerCaseCharAt,LowerCaseBuiltin)) {
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
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch+32);
            }
            ans+= ch;
		}
		System.out.println("Using CharAt:  "+ans);
		return ans;
	}
	public static boolean check(String LowerCaseCharAt,String LowerCaseBuiltin) {
		if(LowerCaseCharAt.length()!=LowerCaseBuiltin.length()) {
			return false;
		}
		else {
			for(int i=0;i<LowerCaseCharAt.length();i++) {
				if(LowerCaseCharAt.charAt(i)!=LowerCaseBuiltin.charAt(i)) {
					return false;
				}
			}
		}
		return true;
	}
}
