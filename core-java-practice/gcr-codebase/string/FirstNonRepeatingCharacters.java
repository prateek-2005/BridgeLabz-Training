import java.util.*;
public class FirstNonRepeatingCharacters {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String Str=sc.nextLine();
		char ans=find(Str);
		if (ans!= '\0') {
            System.out.println("First non-repeating character in the String is: " + ans);
        } else {
            System.out.println("No non-repeating character");
        }
        sc.close();
	}
	public static char find(String Str){
		int[] count= new int[256];
        for (int i=0;i<Str.length();i++) {
            char ch =Str.charAt(i);
            count[ch]++;
        }
        for (int i = 0; i < Str.length(); i++) {
        	char currentch=Str.charAt(i);
        	if(count[currentch]==1) {
        		return currentch;
        	}
        }
        return '\0';
	}
}
