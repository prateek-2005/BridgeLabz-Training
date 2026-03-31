package reflection;
import java.lang.reflect.Field;
class JsonUtil {
    public static String toJson(Object obj) throws Exception {
        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            sb.append("\"").append(fields[i].getName()).append("\":");
            Object value = fields[i].get(obj);
            if (value instanceof String) {
                sb.append("\"").append(value).append("\"");
            } else {
                sb.append(value);
            }
            if (i < fields.length - 1) sb.append(",");
        }
        sb.append("}");
        return sb.toString();
    }
}
class User1 {
    String name;
    int age;

    User1(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
public class JsonRepresentation {
    public static void main(String[] args) throws Exception {
        User1 u = new User1("Amit", 23);
        System.out.println(JsonUtil.toJson(u));
    }
}
