import java.util.*;
public class GenerateBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = sc.nextInt();
        Queue<String> q = new LinkedList<>();
        ArrayList<String> result = new ArrayList<>();
        q.add("1");
        while (n-- > 0) {
            String s = q.remove();
            result.add(s);
            q.add(s + "0");
            q.add(s + "1");
        }
        System.out.println(result);
        sc.close();
    }
}
