import java.util.*;
public class ReverseTheNumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		int N=number;
		int length=0;
		while(N!=0) {
			length++;
			N=N/10;
		}
		int []arr=new int[length];
		int j=0;
		for(int i=0;i<length;i++) {
			arr[j]=number%10;
			number=number/10;
			j++;
		}
		String reversed="";
		for(int i=0;i<length;i++) {
			reversed+=arr[i];
		}
		System.out.println("Reverse Of a Number: "+reversed);
		sc.close();
	}
}
