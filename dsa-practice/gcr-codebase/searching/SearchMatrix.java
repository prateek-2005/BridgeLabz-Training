import java.util.*;
public class SearchMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter target value: ");
        int target = sc.nextInt();
        boolean found = search(matrix, target);
        System.out.println(found ? "Target found" : "Target not found");
        sc.close();
	}
	public static boolean search(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / cols;
            int col = mid % cols;
            if (matrix[row][col] == target) {
                return true;
            } 
            else if (matrix[row][col] > target) {
                right = mid - 1;
            } 
            else {
                left = mid + 1;
            }
        }

        return false;
    }
}
