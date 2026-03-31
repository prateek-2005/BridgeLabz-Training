import java.util.Scanner;
public class ValidateHexColor {
    public static boolean isValidHexColor(String color) {
        String regex = "^#[0-9A-Fa-f]{6}$";
        return color.matches(regex);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Hex Color Code: ");
        String color = sc.nextLine();
        if (isValidHexColor(color)) {
            System.out.println("Valid Hex Color Code");
        } else {
            System.out.println("Invalid Hex Color Code");
        }
        sc.close();
    }
}
