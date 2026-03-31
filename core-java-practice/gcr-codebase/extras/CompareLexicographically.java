import java.util.*;
public class CompareLexicographically {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String Str1=sc.next();
		String Str2=sc.next();
		if(Compare(Str1,Str2)) {
			System.out.println(Str1+" comes before "+Str2+" in lexicographical order.");
		}
		else {
			System.out.println(Str2+" comes before "+Str1+" in lexicographical order.");
		}
		sc.close();
	}
	public static boolean Compare(String Str1,String Str2) {
		int i=0,j=0;
		while(i<Str1.length() && j<Str2.length()) {
			if(Str1.charAt(i)<Str2.charAt(j)) {
				return true;
			}
			else if(Str1.charAt(i)>Str2.charAt(j)){
				return false;
			}
			else {
				i++;
				j++;
			}
		}
		return true;
	}
}
