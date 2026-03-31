import java.util.*;

public class ConcatenateString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String Array Size: ");
		int n = sc.nextInt();
		sc.nextLine();
		String[] Str = new String[n];
		System.out.println("Enter Strings: ");
		for (int i = 0; i < n; i++) {
			Str[i] = sc.nextLine();
		}
		StringBuffer sb = new StringBuffer();
		for (String s : Str) {
			sb.append(s);
		}
		String ans=sb.toString();
		System.out.println("Concatenated String: "+ans);
		sc.close();
	}

}
