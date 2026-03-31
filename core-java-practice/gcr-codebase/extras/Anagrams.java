import java.util.Scanner;
public class Anagrams{

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String Str1=sc.nextLine();
		String Str2=sc.nextLine();
		System.out.println("String 1: "+Str1);
		System.out.println("String 2: "+Str2);
		if(check(Str1,Str2)) {
			System.out.println("Both Strings are Anagram");
		}
		else {
			System.out.println("Both Strings are not Anagram");
		}
		sc.close();
	}
	public static boolean check(String Str1,String Str2) {
		if(Str1.length()!=Str2.length()) {
			return false;
		}
		int []arr1=new int[256];
		int []arr2=new int[256];
		for(int i=0;i<Str1.length();i++) {
			char ch=Str1.charAt(i);
			arr1[ch]++;
		}
		for(int i=0;i<Str2.length();i++) {
			char ch=Str2.charAt(i);
			arr2[ch]++;
		}
		for(int i=0;i<arr1.length;i++) {
			if(arr1[i]!=arr2[i]) {
				return false;
			}
		}
		return true;
	}
}
