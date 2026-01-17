import java.util.*;
public class RemoveDuplicates {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String: ");
		String str=sc.nextLine();
		StringBuilder sb=new StringBuilder();
		HashSet<Character> set=new HashSet<>();
		for (char ch : str.toCharArray()) {
            if (!set.contains(ch)) {
                sb.append(ch);
                set.add(ch);
            }
        }
		String ans=sb.toString();
		System.out.println("Modified String: "+ans);
		sc.close();
	}

}
