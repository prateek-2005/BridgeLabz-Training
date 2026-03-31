import java.util.Scanner;
public class ValidateUsername {
    public static boolean isValidUsername(String username) {
        String regex = "^[A-Za-z][A-Za-z0-9_]{4,14}$";
        return username.matches(regex);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        if (isValidUsername(username)) {
            System.out.println("Valid Username");
        } else {
            System.out.println("Invalid Username");
        }
        sc.close();
    }
}
