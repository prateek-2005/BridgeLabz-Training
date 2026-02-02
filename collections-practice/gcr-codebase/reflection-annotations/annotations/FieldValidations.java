package annotations;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    String username;

    User(String username) {
        try {
            Field f = this.getClass().getDeclaredField("username");
            if (f.isAnnotationPresent(MaxLength.class)) {
                MaxLength max = f.getAnnotation(MaxLength.class);
                if (username.length() > max.value()) {
                    throw new IllegalArgumentException("Username exceeds max length of " + max.value());
                }
            }
            this.username = username;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}

public class FieldValidations {
    public static void main(String[] args) {
        User u1 = new User("Amit"); 
        System.out.println("Username: " + u1.username);

        User u2 = new User("VeryLongUsername"); 
    }
}
