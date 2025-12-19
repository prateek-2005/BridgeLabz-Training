import java.util.*;
public class OddAndEven {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		if(num>0) {
			for(int i=1;i<=num;i++) {
				if (i % 2 == 0) {
                    System.out.println(i + " is an Even number");
                } else {
                    System.out.println(i + " is an Odd number");
                }
			}
		}
		sc.close();
	}

}
