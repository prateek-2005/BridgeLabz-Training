import java.util.*;
public class LongestWord {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String Sentence=sc.nextLine();
		String []Words=Sentence.trim().split(" ");
		String Longest="";
		for(int i=0;i<Words.length;i++) {
			if(Words[i].length()>Longest.length()) {
				Longest=Words[i];
			}
		}
		System.out.println("Longest Word: "+Longest);
		sc.close();
	}

}
