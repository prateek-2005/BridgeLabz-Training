import java.util.*;
public class PallindromeString {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String Str=sc.nextLine();
		if(check(Str)) {
			System.out.println("Pallindrome String Using Start and End");
		}
		else {
			System.out.println("Not A Pallindrome String Using Start and End");
		}
		if(recursive(Str,0,Str.length()-1)) {
			System.out.println("Pallindrome String Using Recursive Apporach");
		}
		else {
			System.out.println("Not A Pallindrome String Using Recursive Apporach");
		}
		if(reverse(Str)) {
			System.out.println("Pallindrome String Using Reverse Array");
		}
		else {
			System.out.println("Not A Pallindrome String Using Reverse Array");
		}
		sc.close();
	}
	public static boolean check(String Str) {
		int start=0;
		int end=Str.length()-1;
		while(start<=end) {
			if(Str.charAt(start)!=Str.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	public static boolean recursive(String Str,int start,int end) {
		if (start >= end) {
            return true;
        }
        if (Str.charAt(start)!=Str.charAt(end)) {
            return false;
        }
        return recursive(Str,start + 1,end - 1);
	}
	public static boolean reverse(String Str) {
		String rev="";
		for(int i=Str.length()-1;i>=0;i--) {
			rev+=Str.charAt(i);
		}
		char []arr=Str.toCharArray();
		char []Rev=rev.toCharArray();
		for(int i=0;i<Str.length();i++) {
			if(arr[i]!=Rev[i]) {
				return false;
			}
		}
		return true;
	}
}
