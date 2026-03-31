import java.util.*;
public class AnalysisText {
	public static void main(String []args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Paragraph: ");
		String paragraph=sc.nextLine();
		String []words=paragraph.split(" ");
		int numberOfWords=0;
		String longestWord="";
		for(int i=0;i<words.length;i++) {
			if(words[i]!="") {
				numberOfWords++;
				if(words[i].length()>longestWord.length()) {
					longestWord=words[i];
				}
			}
		}
		System.out.println("Number Of words in a paragraph: "+numberOfWords);
		System.out.println("Longest Word in a paragraph: "+longestWord);
		sc.close();
	}
}
