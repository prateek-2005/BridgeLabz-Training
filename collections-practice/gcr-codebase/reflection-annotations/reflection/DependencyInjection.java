package reflection;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@interface Inject {
}

class ServiceA {
    void work() {
        System.out.println("ServiceA working");
    }
}

class ServiceB {
    @Inject
    ServiceA serviceA;

    void execute() {
        serviceA.work();
    }
}

class DIContainer {
    private static Map<Class<?>, Object> container = new HashMap<>();

    public static <T> T getBean(Class<T> clazz) throws Exception {
        if (!container.containsKey(clazz)) {
            T obj = clazz.getDeclaredConstructor().newInstance();
            container.put(clazz, obj);

            for (Field f : clazz.getDeclaredFields()) {
                if (f.isAnnotationPresent(Inject.class)) {
                    Object dependency = getBean(f.getType());
                    f.setAccessible(true);
                    f.set(obj, dependency);
                }
            }
        }
        return clazz.cast(container.get(clazz));
    }
}

public class DependencyInjection {
    public static void main(String[] args) throws Exception {
        ServiceB b = DIContainer.getBean(ServiceB.class);
        b.execute();
    }
}
