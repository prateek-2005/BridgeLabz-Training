import java.util.*;

public class NumberChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = Count(n);
        String[] Digits = Store(n);

        System.out.println("Count Of Digits In Number: " + count);
        System.out.println("Digits in number:");
        for (String d : Digits) {
            System.out.print(d + " ");
        }
        System.out.println();

        if (check(Digits)) {
            System.out.println(n + " is a duck number");
        } else {
            System.out.println(n + " is not a duck number");
        }

        if (ArmstrongNumber(n, count)) {
            System.out.println(n + " is an Armstrong Number");
        } else {
            System.out.println(n + " is not an Armstrong Number");
        }

        int[] largest = Largest(Digits);
        System.out.println("Largest Digit: " + largest[0] + " And Second Largest Digit: " + largest[1]);

        int[] smallest = Smallest(Digits);
        System.out.println("Smallest Digit: " + smallest[0] + " And Second Smallest Digit: " + smallest[1]);
        sc.close();
    }

    public static int Count(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt++;
            n /= 10;
        }
        return cnt;
    }

    public static String[] Store(int n) {
        int temp = n;
        int cnt = 0;
        while (temp > 0) {
            cnt++;
            temp /= 10;
        }
        String[] arr = new String[cnt];
        int index = cnt - 1;
        while (n > 0) {
            arr[index] = String.valueOf(n % 10);
            n /= 10;
            index--;
        }
        return arr;
    }

    public static boolean check(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].equals("0")) {
                return true;
            }
        }
        return false;
    }

    public static boolean ArmstrongNumber(int n, int count) {
        int sum = 0;
        int temp = n;
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, count);
            temp /= 10;
        }
        return sum == n;
    }

    public static int[] Largest(String[] Digits) {
        int largest = Integer.MIN_VALUE;
        int secondlargest = Integer.MIN_VALUE;
        for (String d : Digits) {
            int temp = Integer.parseInt(d);
            if (temp > largest) {
                secondlargest = largest;
                largest = temp;
            } else if (temp > secondlargest && temp != largest) {
                secondlargest = temp;
            }
        }
        return new int[]{largest, secondlargest};
    }

    public static int[] Smallest(String[] Digits) {
        int smallest = Integer.MAX_VALUE;
        int secondsmallest = Integer.MAX_VALUE;
        for (String d : Digits) {
            int temp = Integer.parseInt(d);
            if (temp < smallest) {
                secondsmallest = smallest;
                smallest = temp;
            } else if (temp < secondsmallest && temp != smallest) {
                secondsmallest = temp;
            }
        }
        return new int[]{smallest, secondsmallest};
    }
}