package annotations;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@interface CacheResult {
}

interface ExpensiveOperations {
    @CacheResult
    int fibonacci(int n);
}

class ExpensiveOperationsImpl implements ExpensiveOperations {
    public int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

class CachingHandler implements InvocationHandler {
    private final Object target;
    private final Map<String, Object> cache = new HashMap<>();

    public CachingHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(CacheResult.class)) {
            String key = method.getName() + ":" + args[0];
            if (cache.containsKey(key)) {
                System.out.println("Returning cached result for " + key);
                return cache.get(key);
            } else {
                Object result = method.invoke(target, args);
                cache.put(key, result);
                return result;
            }
        } else {
            return method.invoke(target, args);
        }
    }
}

public class CustomCaching {
    public static void main(String[] args) {
        ExpensiveOperations ops = (ExpensiveOperations) Proxy.newProxyInstance(
                ExpensiveOperations.class.getClassLoader(),
                new Class[]{ExpensiveOperations.class},
                new CachingHandler(new ExpensiveOperationsImpl())
        );

        System.out.println("Fibonacci 10: " + ops.fibonacci(10));
        System.out.println("Fibonacci 10: " + ops.fibonacci(10)); 
        System.out.println("Fibonacci 8: " + ops.fibonacci(8));   
        System.out.println("Fibonacci 8: " + ops.fibonacci(8));  
    }
}
