package annotations;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class ProjectFeatures {

    @Todo(task = "Implement login feature", assignedTo = "Amit", priority = "HIGH")
    public void login() {}

    @Todo(task = "Add reporting module", assignedTo = "Ravi")
    public void reporting() {}

    @Todo(task = "Optimize database queries", assignedTo = "Sneha", priority = "HIGH")
    public void optimizeDB() {}
}

public class CreateTodo {
    public static void main(String[] args) {
        Method[] methods = ProjectFeatures.class.getDeclaredMethods();

        for (Method m : methods) {
            if (m.isAnnotationPresent(Todo.class)) {
                Todo t = m.getAnnotation(Todo.class);
                System.out.println("Method: " + m.getName());
                System.out.println("Task: " + t.task());
                System.out.println("Assigned To: " + t.assignedTo());
                System.out.println("Priority: " + t.priority());
                System.out.println("-----------------------");
            }
        }
    }
}