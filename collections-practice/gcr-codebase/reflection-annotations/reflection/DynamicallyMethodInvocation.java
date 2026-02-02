package reflection;
import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicallyMethodInvocation {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Method Name: ");
        String methodName = sc.next();
        System.out.println("Enter 1st Number: ");
        int a = sc.nextInt();
        System.out.println("Enter 2nd Number: ");
        int b = sc.nextInt();
        MathOperations obj = new MathOperations();
        Method m = MathOperations.class.getMethod(methodName, int.class, int.class);
        Object result = m.invoke(obj, a, b);
        System.out.println(result);
        sc.close();
    }
}
