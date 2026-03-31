import java.util.*;
public class EvenAndOddArray {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		if(number<0) {
			System.out.println("Not a Natural Number");
		}
		int []odd=new int[number/2+1];
		int []even=new int[number/2+1];
		int i=0;
		int j=0;
		for(int k=1;k<=number;k++) {
			if(k%2!=0) {
				odd[i]=k;
				i++;
			}
		}
		for(int k=1;k<=number;k++) {
			if(k%2==0) {
				even[j]=k;
				j++;
			}
		}
		System.out.println("Odd Numbers");
		for(int k=0;k<odd.length;k++) {
			System.out.print(odd[k]+" ");
		}
		System.out.println();
		System.out.println("Even Numbers");
		for(int k=0;k<even.length;k++) {
			System.out.print(even[k]+" ");
		}
		sc.close();
	}

}
