import java.util.*;
public class CharacterFrequency {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String Str=sc.nextLine();
		String [][]ans=find(Str);
		System.out.println("Characters\tFrequency");
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i][0]+"\t\t"+ans[i][1]);
		}
		sc.close();
	}
	public static String[][] find(String Str){
		int[] count= new int[256];
        for (int i=0;i<Str.length();i++) {
            char ch =Str.charAt(i);
            count[ch]++;
        }
        String [][]arr=new String[Str.length()][2];
        for(int i=0;i<Str.length();i++) {
        	char ch=Str.charAt(i);
        	if(count[ch]>0) {
        		arr[i][0]=String.valueOf(ch);
        		arr[i][1]=String.valueOf(count[ch]);
        	}
        }
        return arr;
	}
}
