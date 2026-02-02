package reflection;
import java.lang.reflect.Field;
import java.util.Map;

class ObjectMapperUtil {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        T obj = clazz.getDeclaredConstructor().newInstance();

        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            Field f = clazz.getDeclaredField(entry.getKey());
            f.setAccessible(true);
            f.set(obj, entry.getValue());
        }
        return obj;
    }
}

class User {
    String name;
    int age;
}

public class CustomObjectMapper {
    public static void main(String[] args) throws Exception {
        Map<String, Object> map = Map.of(
                "name", "Amit",
                "age", 22
        );

        User u = ObjectMapperUtil.toObject(User.class, map);
        System.out.println(u.name + " " + u.age);
    }
}
