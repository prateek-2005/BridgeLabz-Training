import java.util.Scanner;
public class MultipleCatchBlocks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = null;
        try {
            System.out.print("Enter array size (enter -1 for null array): ");
            int size = sc.nextInt();
            if (size == -1) {
                arr = null;
            } else {
                arr = new int[size];
                System.out.println("Enter " + size + " elements:");
                for (int i = 0; i < size; i++) {
                    arr[i] = sc.nextInt();
                }
            }
            System.out.print("Enter index: ");
            int index = sc.nextInt();
            System.out.println("Value at index " + index + ": " + arr[index]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        }
        catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
        sc.close();
    }
}
