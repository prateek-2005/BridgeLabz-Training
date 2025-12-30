import java.util.*;
class PallindromeChecker {
	String text;
	PallindromeChecker(String text) {
		this.text = text;
	}
	boolean Check() {
		String modified = text.replaceAll("\\s+", "").toLowerCase();
		StringBuilder sb = new StringBuilder(modified);
		String reversed = sb.reverse().toString();
		return reversed.equals(text);
	}
	void Display() {
		if (Check()) {
			System.out.println(text + " is palindrome");
		} else {
			System.out.println(text + " is not Palindrome");
		}
	}
}
public class CheckPallindrome {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Text: ");
		String text=sc.next();
		PallindromeChecker pallindrome=new PallindromeChecker(text);
		pallindrome.Display();
		sc.close();	
	}

}
