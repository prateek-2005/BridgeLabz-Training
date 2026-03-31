import java.util.*;

public class IndexOutOfBoundException{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        generateException(str);
        handleException(str);

        sc.close();
    }
    public static void generateException(String str) {
        char ch = str.charAt(str.length());
        System.out.println(ch);
    }
    public static void handleException(String str) {
        try {
            char ch = str.charAt(str.length());
            System.out.println(ch);
        }
        catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException caught: " + e.getMessage());
        }
    }
}
