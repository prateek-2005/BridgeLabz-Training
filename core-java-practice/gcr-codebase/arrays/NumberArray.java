import java.util.*;
public class NumberArray {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int []number=new int[5];
		for(int i=0;i<5;i++) {
			number[i]=sc.nextInt();
		}
		for(int i=0;i<number.length;i++) {
			if(number[i]>0) {
				if(number[i]%2==0) {
					System.out.println("Positive Even Number: "+number[i]);
				}
				else {
					System.out.println("Positive Odd Number: "+number[i]);
				}
			}
			else if(number[i]==0) {
				System.out.println("Zero: "+number[i]);
			}
			else {
				System.out.println("Negative Number: "+number[i]);
			}
		}
		if(number[0]>number[4]) {
			System.out.println(number[0]+"is greater than "+number[4]);
		}
		else if(number[0]<number[4]) {
			System.out.println(number[0]+"is greater than "+number[4]);
		}
		else {
			System.out.println(number[0]+"is equals to "+number[4]);
		}
		sc.close();
	}

}
