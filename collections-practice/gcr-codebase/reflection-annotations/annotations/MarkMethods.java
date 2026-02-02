package annotations;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface ImportantMethod {
    String level() default "HIGH";
}

class Project {
    @ImportantMethod
    public void criticalTask() {
        System.out.println("Critical Task Executed");
    }

    @ImportantMethod(level = "MEDIUM")
    public void regularTask() {
        System.out.println("Regular Task Executed");
    }

    public void optionalTask() {
        System.out.println("Optional Task Executed");
    }
}

public class MarkMethods {
    public static void main(String[] args) throws Exception {
        Method[] methods = Project.class.getDeclaredMethods();

        for (Method m : methods) {
            if (m.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod im = m.getAnnotation(ImportantMethod.class);
                System.out.println(m.getName() + " - Level: " + im.level());
            }
        }

        Project p = new Project();
        p.criticalTask();
        p.regularTask();
        p.optionalTask();
    }
}
