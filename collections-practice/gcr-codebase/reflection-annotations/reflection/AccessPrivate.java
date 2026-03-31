package reflection;
import java.lang.reflect.Field;
class Person {
    private int age;
}
public class AccessPrivate {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        Field f = Person.class.getDeclaredField("age");
        f.setAccessible(true);
        f.setInt(p, 25);
        System.out.println(f.getInt(p));
    }
}
