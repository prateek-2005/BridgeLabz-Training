import java.util.*;
public class FactorsMethod {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int []factors=get(n);
		System.out.println("Factors Of Number:");
		for(int i=0;i<factors.length;i++) {
			System.out.print(factors[i]+" ");
		}
		System.out.println();
		System.out.println("GreatestFactor Of the Number: "+GreatestFactor(factors));
		System.out.println("Sum Of Factors: "+Sum(factors));
		System.out.println("Product Of Factors: "+Product(factors));
		System.out.println("Product Of Cube Of Factors: "+Cube(factors));
		sc.close();
	}
	public static int[] get(int n) {
		int count=0;
		for(int i=1;i<n;i++) {
			if(n%i==0) {
				count++;
			}
		}
		int []arr=new int[count];
		int index=0;
		for(int i=1;i<n;i++) {
			if(n%i==0) {
				arr[index]=i;
				index++;
			}
		}
		return arr;
	}
	public static int GreatestFactor(int []factors) {
		return factors[factors.length-1];
	}
	public static int Sum(int []factors) {
		int sum=0;
		for(int i=0;i<factors.length;i++) {
			sum+=factors[i];
		}
		return sum;
	}
	public static int Product(int []factors) {
		int prod=1;
		for(int i=0;i<factors.length;i++) {
			prod*=factors[i];
		}
		return prod;
	}
	public static int Cube(int []factors) {
		int prod=1;
		for(int i=0;i<factors.length;i++) {
			prod*=Math.pow(factors[i],3);
		}
		return prod;
	}
}
