import java.util.*;
public class StringFormatter {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Paragraph: ");
		String paragraph=sc.nextLine();
		String result="";
		String word="";
		for(int i=0;i<paragraph.length();i++) {
			if(i==0 && !(paragraph.charAt(i)=='.' || paragraph.charAt(i)=='!' || paragraph.charAt(i)=='?' || paragraph.charAt(i)==',')) {
				int ascii=paragraph.charAt(i);
				if(ascii>=97 && ascii<=122) {
					ascii=ascii-32;
				}
				char ch=(char)ascii;
				word+=ch;
			}
			else if(paragraph.charAt(i)=='.' || paragraph.charAt(i)=='!' || paragraph.charAt(i)=='?' || paragraph.charAt(i)==',') {
				result+=word;
				result+=paragraph.charAt(i);
				result+=' ';
				word="";
				if(paragraph.charAt(i)!=',') {
					i++;
					if(i<paragraph.length()) {
						int ascii=paragraph.charAt(i);
						if(ascii>=97 && ascii<=122) {
							ascii=ascii-32;
						}
						char ch=(char)ascii;
						word+=ch;
					}
				}
			}
			else if(paragraph.charAt(i)==' ') {
				int j=i;
				while(j<paragraph.length()-1 && paragraph.charAt(j+1)==' ') {
					j++;
				}
				i=j;
				result+=word;
				result+=' ';
				word="";
			}
			else {
				word+=paragraph.charAt(i);
			}
		}
		result+=word;
		result=result.trim();
		System.out.println(result);
		sc.close();
	}

}
