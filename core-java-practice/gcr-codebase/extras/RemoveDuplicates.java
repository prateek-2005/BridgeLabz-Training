import java.util.*;
public class RemoveDuplicates {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String Str=sc.next();
		System.out.println("Original String: "+Str);
		String ans=Remove(Str);
		System.out.println("Modified Stirng: "+ans);
		sc.close();
	}
	public static String Remove(String Str) {
		String ans="";
		int []count=new int[256];
		for(int i=0;i<Str.length();i++) {
			int temp=Str.charAt(i);
			if(count[temp]==0) {
				ans+=Str.charAt(i);
				count[temp]++;
			}
		}
		return ans;
	}
}
