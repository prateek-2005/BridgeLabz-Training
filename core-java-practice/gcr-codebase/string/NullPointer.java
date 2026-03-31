public class NullPointer{

    public static void main(String[] args) {
        generateException();
        handleException();
    }
    public static void generateException() {
        String text = null;
        System.out.println(text.length());
    }
    public static void handleException() {
        String text = null;
        try {
            System.out.println(text.length());
        }
        catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        }
    }
}
