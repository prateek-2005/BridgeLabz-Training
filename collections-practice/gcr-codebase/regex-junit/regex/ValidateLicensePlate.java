import java.util.Scanner;
public class ValidateLicensePlate {
    public static boolean isValidLicensePlate(String plate) {
        String regex = "^[A-Z]{2}[0-9]{4}$";
        return plate.matches(regex);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter License Plate Number: ");
        String plate = sc.nextLine();
        if (isValidLicensePlate(plate)) {
            System.out.println("Valid License Plate Number");
        } else {
            System.out.println("Invalid License Plate Number");
        }
        sc.close();
    }
}
