import java.util.*;
public class MultiplicationTableArray {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		int []arr=new int[10];
		for(int i=0;i<10;i++) {
			arr[i]=number*(i+1);
		}
		for(int i=0;i<arr.length;i++) {
			System.out.println(number+" * "+(i+1)+" = "+arr[i]);
		}
		sc.close();
	}

}
