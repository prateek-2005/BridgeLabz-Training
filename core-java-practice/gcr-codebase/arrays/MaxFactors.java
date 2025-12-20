import java.util.*;

public class MaxFactors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int maxfactor = 10;
        int[] ans = new int[maxfactor];
        int i = 0;
        for (int j = 1; j <= number; j++) {
            if (number % j == 0) {
                if (i == maxfactor) {
                    maxfactor = maxfactor * 2;
                    int[] temp = new int[maxfactor];

                    for (int k = 0; k < ans.length; k++) {
                        temp[k] = ans[k];
                    }
                    ans = temp;
                }
                ans[i] = j;
                i++;
            }
        }

        System.out.println("Factors of the number are:");
        for (int c = 0; c < i; c++) {
            System.out.print(ans[c] + " ");
        }

        sc.close();
    }
}
