import java.util.*;
public class NumberFormat {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String str = sc.next();
        generateException(str);
        handleException(str);
        sc.close();
	}
	public static void generateException(String str) {
        System.out.println(Integer.parseInt(str));
    }
	public static void handleException(String str) {
        try {
            System.out.println(Integer.parseInt(str));
        }
        catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e.getMessage());
        }
    }
}
