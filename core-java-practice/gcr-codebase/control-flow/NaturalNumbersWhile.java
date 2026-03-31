import java.util.*;
public class NaturalNumbersWhile {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		if(num>0) {
			int SumUsingFormula=num*(num+1)/2;
			int SumUsingWhile=0;
			while(num>0) {
				SumUsingWhile+=num;
				num--;
			}
			if(SumUsingFormula==SumUsingWhile) {
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
