import java.util.*;

class InvalidScoreException extends Exception {
	public InvalidScoreException(String message) {
		super(message);
	}
}

public class StudentScoreAnalyzer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter Number Of Students: ");
			int n = sc.nextInt();
			int[] marks = new int[n];
			for (int i = 0; i < n; i++) {
				System.out.print("Enter marks of student " + (i + 1) + ": ");
				marks[i] = sc.nextInt();
				if (marks[i] < 0 || marks[i] > 100) {
					throw new InvalidScoreException("Invalid score! Marks must be between 0 and 100.");
				}
			}
			double averageMarks = findAverage(marks);
			int minimumMarks = findMin(marks);
			int maximumMarks = findMax(marks);
			System.out.println("Average Marks Of Class: " + averageMarks);
			System.out.println("Minimum Marks Of Class: " + minimumMarks);
			System.out.println("Maximum Marks Of Class: " + maximumMarks);
			}
		catch (InvalidScoreException e) {
			System.out.println(e.getMessage());
		} finally {
			sc.close();
		}
	}

	public static double findAverage(int[] marks) {
		int total = 0;
		for (int i : marks) {
			total += i;
		}
		return (double) total / marks.length;
	}

	public static int findMin(int[] marks) {
		int minimum = Integer.MAX_VALUE;
		for (int i : marks) {
			minimum = Math.min(i, minimum);
		}
		return minimum;
	}

	public static int findMax(int[] marks) {
		int maximum = Integer.MIN_VALUE;
		for (int i : marks) {
			maximum = Math.max(i, maximum);
		}
		return maximum;
	}
}
