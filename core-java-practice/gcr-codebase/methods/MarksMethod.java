import java.util.*;
public class MarksMethod {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int [][]marks=generate(n);
		double [][]result=calculate(marks);
		display(marks,result);
		sc.close();
	}
	public static int[][] generate(int n) {
        int[][] Marks= new int[n][3];
        for (int i = 0; i < n; i++) {
        	Marks[i][0] = (int)(Math.random() * 90) + 10; // Physics
        	Marks[i][1] = (int)(Math.random() * 90) + 10; // Chemistry
        	Marks[i][2] = (int)(Math.random() * 90) + 10; // Math
        }
        return Marks;
    }
	public static double[][] calculate(int[][] marks) {
	        int n = marks.length;
	        double[][] results = new double[n][3];
	        for (int i = 0; i < n; i++) {
	            int total = marks[i][0] + marks[i][1] + marks[i][2];
	            double average = (double) total / 3;
	            double percentage = ((double) total / 300) * 100;
	            average = Math.round(average * 100.0) / 100.0;
	            percentage = Math.round(percentage * 100.0) / 100.0;
	            results[i][0] = total;
	            results[i][1] = average;
	            results[i][2] = percentage;
	        }
	        return results;
	}
	public static void display(int[][] marks, double[][] result) {
        System.out.println("ID\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage");
        for (int i = 0; i < marks.length; i++) {
            System.out.println((i+1) + "\t" +marks[i][0] + "\t" +marks[i][1] + "\t\t" +marks[i][2] + "\t" +
                    result[i][0] + "\t" +result[i][1] + "\t" +result[i][2] + "%");
        }
    }

}
