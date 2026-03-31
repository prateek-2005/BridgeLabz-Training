import java.util.*;
public class CheckStringEqual {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String Str1=sc.next();
		String Str2=sc.next();
		//Checking two Strings are equal using charAt
		boolean check=true;
		if(Str1.length()!=Str2.length()) {
			check=false;
		}
		else {
			for(int i=0;i<Str1.length();i++) {
				if(Str1.charAt(i)!=Str2.charAt(i)) {
					check=false;
				}
			}
		}
		if(check) {
			System.out.println("Using CharAt Both String are equals");
		}
		else {
			System.out.println("Using CharAt Both String are not equals");
		}
		//Checking two Strings are equal using In-built Functions
		if(Str1.equals(Str2)) {
			System.out.println("Using in-built functions Both String are equals");
		}
		else {
			System.out.println("Using in-built functions Both String are not equals");
		}
		sc.close();
	}

}
