import java.util.*;
public class MultiplicationArray {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		int []ans=new int[4];
		for(int i=6;i<=9;i++) {
			ans[i-6]=number*i;
		}
		for(int i=6;i<=9;i++) {
			System.out.println(number+" * "+i+" ="+ans[i-6]);
		}
		sc.close();
	}

}
