import java.util.*;
public class CharactersInAString {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String Str=sc.next();
		char []CharactersUsingCharAt=FindUsingCharAt(Str);
		char []CharactersUsingInBuilt=FindUsingToCharArray(Str);
		System.out.println("CharactersUsingCharAt");
		for(int i=0;i<Str.length();i++) {
			System.out.print(CharactersUsingCharAt[i]+" ");
		}
		System.out.println();
		System.out.println("CharactersUsingInBuilt");
		for(int i=0;i<Str.length();i++) {
			System.out.print(CharactersUsingInBuilt[i]+" ");
		}
		System.out.println();
		if(check(CharactersUsingCharAt,CharactersUsingInBuilt)) {
			System.out.println("Both Arrays Are Equal");
		}
		else {
			System.out.println("Both Arrays Are Not Equals");
		}
		sc.close();
	}
	public static char[] FindUsingCharAt(String Str) {
		char []ch=new char[Str.length()];
		int index=0;
		for(int i=0;i<Str.length();i++) {
			ch[index]=Str.charAt(i);
			index++;
		}
		return ch;
	}
	public static char[] FindUsingToCharArray(String Str) {
		return Str.toCharArray();
	}
	public static boolean check(char []CharactersUsingCharAt,char []CharactersUsingInBuilt) {
		for(int i=0;i<CharactersUsingCharAt.length;i++) {
			if(CharactersUsingCharAt[i]!=CharactersUsingInBuilt[i]) {
				return false;
			}
		}
		return true;
	}
}
