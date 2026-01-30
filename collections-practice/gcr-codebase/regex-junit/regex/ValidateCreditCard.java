import java.util.Scanner;
public class ValidateCreditCard {
    public static boolean isValidCard(String cardNumber) {
        String regex = "^(4\\d{15}|5\\d{15})$";
        return cardNumber.matches(regex);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Credit Card Number: ");
        String cardNumber = sc.nextLine();
        if (isValidCard(cardNumber)) {
            System.out.println("Valid Credit Card Number");
        } else {
            System.out.println("Invalid Credit Card Number");
        }
        sc.close();
    }
}
