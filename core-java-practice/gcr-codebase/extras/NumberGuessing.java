import java.util.*;

public class NumberGuessing{
	static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int low = 1;
        int high = 100;
        boolean guessed = false;
        System.out.println("number between 1 and 100.");
        while (!guessed) {
            int guess = generate(low, high);
            System.out.println("Computer guess: " + guess);

            String feedback = get();

            if (feedback.equalsIgnoreCase("correct")) {
                System.out.println("Computer guessed correctly!");
                guessed = true;
            } 
            else if (feedback.equalsIgnoreCase("high")) {
                high = guess - 1;
            } 
            else if (feedback.equalsIgnoreCase("low")) {
                low = guess + 1;
            }
        }
        sc.close();
    }
    public static int generate(int low, int high) {
    	Random random = new Random();
        return random.nextInt(high - low + 1) + low;
    }
    public static String get() {
        System.out.print("Is it high, low, or correct? ");
        return sc.next();
    }
}
