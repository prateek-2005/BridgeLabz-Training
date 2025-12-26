import java.util.*;
public class CountVowelAndConsotants {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		int []ans=count(str);
		System.out.println("Count Of Vowels In String: "+ans[0]);
		System.out.println("Count Of  Consonants In String: "+ans[1]);
		sc.close();
	}
	public static int[] count(String str) {
		int VowelCount=0;
		int ConsonantsCount=0;
		for(int i=0;i<str.length();i++) {
			if(check(str.charAt(i)).equals("Vowel")) {
				VowelCount++;
			}
			else if(check(str.charAt(i)).equals("Consonant")) {
				ConsonantsCount++;
			}
		}
		int []cnt={VowelCount,ConsonantsCount};
		return cnt;
	}
	public static String check(char ch) {
		if(ch>='A' && ch<='Z') {
			ch=(char)(ch+32);
		}
		 if (ch >= 'a' && ch <= 'z') {
	            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
	                return "Vowel";
	            } else {
	                return "Consonant";
	            }
	    }
	    return "Not a Letter";
	}

}
