import java.util.*;
public class DigitsOfNumber2 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int max = 10;
        int[] Digits = new int[max];
        int i = 0;
        while (number != 0) {
            if (i == max) {
                max = max + 10;
                int[] temp = new int[max];
                for (int k = 0; k < Digits.length; k++) {
                    temp[k] = Digits[k];
                }
                Digits = temp;
            }
            Digits[i] = number % 10;
            number = number / 10;
            i++;
        }
        int largest = 0;
        int secondlargest = -1;
        for (int j = 0; j < i; j++) {
            if (Digits[j] > largest) {
                secondlargest = largest;
                largest = Digits[j];
            } else if (Digits[j] > secondlargest && Digits[j] != largest) {
                secondlargest = Digits[j];
            }
        }

        System.out.println("Largest " + largest);
        System.out.println("Second Largest " + secondlargest);

        sc.close();
    }

}
