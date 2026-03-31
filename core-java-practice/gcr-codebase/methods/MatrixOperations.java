import java.util.*;
public class MatrixOperations {
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
        System.out.println("Addition Of Two Matrices");
        int[][] add = Addition(arr1, arr2);
        display(add);
        System.out.println("Subtraction Of Two Matrices");
        int[][] sub = Subtraction(arr1, arr2);
        display(sub);
        System.out.println("Multiplication Of Two Matrices");
        int[][] mul = multiplication(arr1, arr2);
        display(mul);
        sc.close();
    }
    public static int[][] generate(int row, int col) {
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = (int)(Math.random() * 10);
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
    public static int[][] Addition(int[][] arr1, int[][] arr2) {
        int rows = arr1.length;
        int cols = arr1[0].length;
        int[][] arr = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return arr;
    }
    public static int[][] Subtraction(int[][] arr1, int[][] arr2) {
        int rows = arr1.length;
        int cols = arr1[0].length;
        int[][] arr = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = arr1[i][j] - arr2[i][j];
            }
        }
        return arr;
    }
    public static int[][] multiplication(int[][] arr1, int[][] arr2) {
        int rowsA = arr1.length;
        int colsA = arr1[0].length;
        int colsB = arr2[0].length;

        int[][] arr= new int[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    arr[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return arr;
    }
}