import java.util.*;
public class RemoveSpecificCharacter {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String Str=sc.next();
		System.out.println("Original String: "+Str);
		System.out.println("Character To Remove:");
		char ch=sc.next().charAt(0);
		String ans=Remove(Str,ch);
		System.out.println("Modified Stirng: "+ans);
		sc.close();
	}
	public static String Remove(String Str,char ch) {
		String ans="";
		for(int i=0;i<Str.length();i++) {
			if(ch==Str.charAt(i)) {
				continue;
			}
			else {
				ans+=Str.charAt(i);
			}
		}
		return ans;
	}
}
