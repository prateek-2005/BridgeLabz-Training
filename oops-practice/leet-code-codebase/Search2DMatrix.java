import java.util.*;
public class Search2DMatrix {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Rows: ");
		int n=sc.nextInt();
		System.out.println("Enter Columns: ");
		int m=sc.nextInt();
		int [][]matrix=new int[n][m];
		System.out.println("Enter Elements: ");
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				matrix[i][j]=sc.nextInt();
			}
		}
		System.out.println("Enter Target Element: ");
		int target=sc.nextInt();
		if(searchMatrix(matrix,target)) {
			System.out.println("Target Element exists in the array");
		}
		else {
			System.out.println("Target Element Does not exists");
		}
		sc.close();
	}
	public static boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int i=0,j=n-1;
        while(i<m && j>=0){
            if(matrix[i][j]==target) {
            	return true;
            }
            else if(matrix[i][j]>target) {
            	j--;
            }
            else if(matrix[i][j]<target) {
            	i++;
            }
        }
        return false;
    }
}
