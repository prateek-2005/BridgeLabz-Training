import java.util.*;
public class Convert2DInto1DArray {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		int [][]arr=new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		int []arr1D=new int[m*n];
		int index=0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				arr1D[index]=arr[i][j];
				index++;
			}
		}
		System.out.println("2D Array:");
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("1D Array:");
		for(int i=0;i<arr1D.length;i++) {
			System.out.print(arr1D[i]+" ");
		}
		sc.close();
	}

}
