import java.util.Scanner;

public class StudentScores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] scores = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Enter score for student " + (i + 1) + ": ");
                if (sc.hasNextInt()) {
                    int score = sc.nextInt();
                    if (score >= 0) {
                        scores[i] = score;
                        sum += score;
                        break;
                    }
                } else {
                    sc.next();
                }
                System.out.println("Invalid score. Enter a non-negative number.");
            }
        }
        double average = (double) sum / n;
        int highest = scores[0];
        int lowest = scores[0];
        for (int score : scores) {
            if (score > highest) highest = score;
            if (score < lowest) lowest = score;
        }
        System.out.println("\nAverage Score: " + average);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);
        System.out.println("\nScores above average:");
        for (int score : scores) {
            if (score > average) {
                System.out.println(score);
            }
        }

        sc.close();
    }
}
