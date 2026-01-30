import java.util.Scanner;
public class SpaceNormalizer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String input = sc.nextLine();
        String output = input.replaceAll("\\s+", " ");
        System.out.println("After replacing multiple spaces:");
        System.out.println(output);
        sc.close();
    }
}
