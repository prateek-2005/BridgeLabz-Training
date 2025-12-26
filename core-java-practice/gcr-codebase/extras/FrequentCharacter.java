import java.util.*;
public class FrequentCharacter {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String Str=sc.nextLine();
		System.out.println("String: "+Str);
		char ch=find(Str);
		System.out.println("Most Frequent Character: "+ch);
		sc.close();
	}
	public static char find(String Str) {
		int []count=new int[256];
		for(int i=0;i<Str.length();i++) {
			int temp=Str.charAt(i);
			count[temp]++;
		}
		int maxi=0;
		char ch=' ';
		for(int i=0;i<256;i++) {
			if(count[i]>maxi) {
				ch=(char)(i);
				maxi=count[i];
			}
		}
		return ch;
	}
}
