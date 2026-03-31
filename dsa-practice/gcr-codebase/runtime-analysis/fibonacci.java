public class fibonacci{
    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 30;

        long startRec1 = System.nanoTime();
        int fr=fibonacciRecursive(n1);
        long endRec1 = System.nanoTime();
        System.out.println("Recursive Fibonacci Of  " + n1 +"is :  "+fr+" With Time: " + (endRec1 - startRec1) + " ns");

        long startItr1 = System.nanoTime();
        int fi=fibonacciIterative(n1);
        long endItr1 = System.nanoTime();
        System.out.println("Iterative Fibonacci Of " + n1 +" is :  "+fi+ " With Time: " + (endItr1 - startItr1) + " ns");

        long startRec2 = System.nanoTime();
        fr=fibonacciRecursive(n2);
        long endRec2 = System.nanoTime();
        System.out.println("Recursive Fibonacci Of Of " + n2 +" is :  "+fr+ " With Time: " + (endRec2 - startRec2) + " ns");

        long startItr2 = System.nanoTime();
        fi=fibonacciIterative(n2);
        long endItr2 = System.nanoTime();
        System.out.println("Iterative Fibonacci " + n2 + " is :  "+fi+ " With Time: " + (endItr2 - startItr2) + " ns");
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
        	return n;
        } 
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) {
        	return n;
        } 
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
