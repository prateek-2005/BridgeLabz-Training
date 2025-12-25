import java.util.*;
public class HandShakesMethod {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int NumberOfStudents=sc.nextInt();
		System.out.println("The Number Of Handshakes are: "+Calculate(NumberOfStudents));
		sc.close();
	}
	public static int Calculate(int n) {
		return (n*(n-1))/2;
	}
}
