import java.util.*;
public class LengthOfString {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String Str=sc.next();
		int LengthUsingCharAt=find(Str);
		int LengthUsingInBuilt=Str.length();
		System.out.println("Length of string using CharAt: "+LengthUsingCharAt);
		System.out.println("Length of string using BuiltIn: "+LengthUsingInBuilt);
	}
	public static int find(String Str) {
		int count = 0;
        try {
            while (true) {
                Str.charAt(count); 
                count++;           
            }
        } catch (IndexOutOfBoundsException e) {
        }
        return count;
	}
}
