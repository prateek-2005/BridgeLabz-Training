import java.util.*;
public class ReverseString {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String: ");
		String str=sc.next();
		StringBuilder sb=new StringBuilder();
		sb.append(str);
		sb.reverse();
		String rev=sb.toString();
		System.out.println("Reversed String : "+rev);
		sc.close();
	}

}
