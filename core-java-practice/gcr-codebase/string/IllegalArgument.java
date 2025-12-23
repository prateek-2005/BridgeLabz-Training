import java.util.*;

public class IllegalArgument{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        generateException(str);
        handleException(str);
        sc.close();
    }
    public static void generateException(String str) {
        System.out.println(str.substring(5, 2));
    }
    public static void handleException(String str) {
        try {
            System.out.println(str.substring(6, 3));
        }
        catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }
}
