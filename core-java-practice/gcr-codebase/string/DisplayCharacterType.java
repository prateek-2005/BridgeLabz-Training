import java.util.*;
public class DisplayCharacterType {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String Str=sc.next();
		String [][]ans=find(Str);
		System.out.println("Character\tType");
	    for (int i = 0; i < ans.length; i++) {
	         System.out.println(ans[i][0] + "\t\t" + ans[i][1]);
	    }
	    sc.close();
	}
	public static String[][] find(String Str){
		String [][]arr=new String[Str.length()][2];
		for(int i=0;i<Str.length();i++) {
			arr[i][0]=String.valueOf(Str.charAt(i));
			arr[i][1]=check(Str.charAt(i));
		}
		return arr;
	}
	public static String check(char ch) {
		if(ch>='A' && ch<='Z') {
			ch=(char)(ch+32);
		}
		 if (ch >= 'a' && ch <= 'z') {
	            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
	                return "Vowel";
	            } else {
	                return "Consonant";
	            }
	    }
	    return "Not a Letter";
	}
}
