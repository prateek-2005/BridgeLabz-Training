import java.util.*;

public class NaturalNumbersFor {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		if(num>0) {
			int SumUsingFormula=num*(num+1)/2;
			int SumUsingFor=0;
			for(int i=1;i<=num;i++) {
				SumUsingFor+=i;
			}
			if(SumUsingFormula==SumUsingFor) {
				System.out.println("Both Computations were correct");
			}
			else {
				System.out.println("Both Computations were not correct");
			}
		}
		else {
			System.out.println("Number is not a natural number");
		}
		sc.close();
	}

}
