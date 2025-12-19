import java.util.*;

public class MultiplesOfNumberWhile {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		if(number>0 && number<100) {
			int temp=100;
			while(temp!=0) {
				if(temp%number==0) {
					System.out.println(temp);
				}
				temp--;
			}
		}
		sc.close();
	}
}
