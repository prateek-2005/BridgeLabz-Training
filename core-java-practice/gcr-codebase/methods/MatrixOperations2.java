import java.util.*;

public class MatrixOperations2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int[][] arr1 = generate(row, col);
		int[][] arr2 = generate(row, col);
		System.out.println("Matrix-1 Generated");
		display(arr1);
		System.out.println("Matrix-2 Generated");
		display(arr2);
		System.out.println("Transpose Of Matrix-1");
		int [][]Transpose=transpose(arr1);
		display(Transpose);
		int [][]Matrix2=generate(2,2);
		System.out.println("Matrix-2 Generated");
		display(Matrix2);
		int [][]Matrix3=generate(3,3);
		System.out.println("Matrix-3 Generated");
		display(Matrix3);
		System.out.println("Determinant Of 2*2 Matrix:  "+determinant2(Matrix2));
		System.out.println("Determinant Of 3*3 Matrix:  "+determinant3(Matrix3));
		System.out.println("Inverse Of 2X2 Matrix");
		double [][]inv2=inverse2(Matrix2);
		display2(inv2);
		System.out.println("Inverse Of 3X3 Matrix");
		double [][]inv3=inverse3(Matrix3);
		display2(inv3);
		sc.close();
	}

	public static int[][] generate(int row, int col) {
		int[][] arr = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				arr[i][j] = (int) (Math.random() * 10);
			}
		}
		return arr;
	}

	public static void display(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void display2(double[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static int[][] transpose(int[][] matrix) {
	    int row= matrix.length;
	    int col= matrix[0].length;
	    int[][] transposed= new int[col][row]; 
	    for (int i = 0; i < row; i++) {
	        for (int j = 0; j < col; j++) {
	            transposed[j][i] = matrix[i][j];
	        }
	    }
	    return transposed;
	}
	public static int determinant2(int[][] matrix) {
	    return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
	}
	public static int determinant3(int[][] matrix) {
		int a = matrix[0][0];
	    int b = matrix[0][1];
	    int c = matrix[0][2];
	    int d = matrix[1][0];
	    int e = matrix[1][1];
	    int f = matrix[1][2];
	    int g = matrix[2][0];
	    int h = matrix[2][1];
	    int i = matrix[2][2];
	    return (a * (e * i - f * h)) - (b * (d * i - f * g))+ (c * (d * h - e * g));
	}
	public static double[][] inverse2(int[][] matrix) {
	    int a = matrix[0][0];
	    int b = matrix[0][1];
	    int c = matrix[1][0];
	    int d = matrix[1][1];
	    int det = (a * d) - (b * c);
	    if (det == 0) {
	        return new double[][] {};
	    }
	    double[][] inverse = new double[2][2];
	    inverse[0][0] = d / (double) det;
	    inverse[0][1] = -b / (double) det;
	    inverse[1][0] = -c / (double) det;
	    inverse[1][1] = a / (double) det;
	    return inverse;
	}
	public static double[][] inverse3(int[][] matrix) {
	    int det = determinant3(matrix);
	    if (det == 0) {
	    	return new double[][] {};
	    }
	    double[][] cofactor = new double[3][3];
	    for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	            cofactor[i][j] = getMinor(matrix, i, j) * ((i + j) % 2 == 0 ? 1 : -1);
	        }
	    }
	    double[][] adjoint = new double[3][3];
	    for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	            adjoint[i][j] = cofactor[j][i];
	        }
	    }
	    double[][] inverse = new double[3][3];
	    for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	            inverse[i][j] = adjoint[i][j] / det;
	        }
	    }

	    return inverse;
	}
	public static int getMinor(int[][] m, int row, int col) {
	    int[] val= new int[4];
	    int idx = 0;
	    for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	            if (i != row && j != col) {
	                val[idx++] = m[i][j];
	            }
	        }
	    }
	    return val[0] * val[3] - val[1] * val[2];
	}
}
