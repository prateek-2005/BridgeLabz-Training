package annotations;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@interface JsonField {
    String name();
}

class User2 {
    @JsonField(name = "user_name")
    String username;

    @JsonField(name = "user_age")
    int age;

    User2(String username, int age) {
        this.username = username;
        this.age = age;
    }
}

class JsonSerializer {
    public static String toJson(Object obj) throws Exception {
        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        boolean first = true;
        for (Field f : fields) {
            f.setAccessible(true);
            if (f.isAnnotationPresent(JsonField.class)) {
                if (!first) sb.append(",");
                JsonField jf = f.getAnnotation(JsonField.class);
                sb.append("\"").append(jf.name()).append("\":");
                Object value = f.get(obj);
                if (value instanceof String) sb.append("\"").append(value).append("\"");
                else sb.append(value);
                first = false;
            }
        }
        sb.append("}");
        return sb.toString();
    }
}

public class CustomSerialization {
    public static void main(String[] args) throws Exception {
        User2 u = new User2("Amit", 25);
        System.out.println(JsonSerializer.toJson(u));
    }
}
