package reflection;
import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "OLD_KEY";
}

public class AccessAndModify {
    public static void main(String[] args) throws Exception {
        Class<Configuration> cls = Configuration.class;

        Field f = cls.getDeclaredField("API_KEY");
        f.setAccessible(true);

        f.set(null, "NEW_KEY");
        System.out.println(f.get(null));
    }
}
