import java.util.*;
public class ReplaceWords {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String Sentence=sc.nextLine();
		System.out.println("Original Sentence:  "+Sentence);
		System.out.println("Enter the Words to be Replaced: ");
		String Rep=sc.nextLine();
		System.out.println("Enter the Word To be Replaced By: ");
		String Str=sc.nextLine();
		String []Words=Sentence.trim().split(" ");
		String ans=get(Words,Rep,Str);
		System.out.println("Modified Sentence: "+ans);
		sc.close();
	}
	public static String get(String[] words,String Rep,String Str) {
		String ans="";
		for(int i=0;i<words.length;i++) {
			if(words[i].equals(Rep)) {
				ans+=Str;
				ans+=" ";
			}
			else {
				ans+=words[i];
				ans+=" ";
			}
		}
		return ans;
	}
}
