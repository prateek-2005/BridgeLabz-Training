import java.util.*;
public class PrintAndSum {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double []arr=new double[10];
		double total=0.0;
		int i=0;
		while(true) {
			double num=sc.nextDouble();
			if(num<=0) {
				break;
			}
			if(i==10) {
				break;
			}
			arr[i]=num;
			i++;
		}
		System.out.println("Numbers are");
		for(int j=0;j<arr.length;j++) {
			System.out.println(arr[j]+" ");
			total+=arr[j];
		}
		System.out.println("Total Sum: "+total);
		sc.close();
	}

}
