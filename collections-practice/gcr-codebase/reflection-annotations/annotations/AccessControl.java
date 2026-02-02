package annotations;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface RoleAllowed {
    String value();
}

class AdminTasks {
    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("User deleted successfully!");
    }

    public void viewDashboard() {
        System.out.println("Viewing dashboard...");
    }
}

public class AccessControl {
    public static void main(String[] args) throws Exception {
        String currentUserRole = "USER"; // change to "ADMIN" to allow

        AdminTasks tasks = new AdminTasks();
        Method[] methods = AdminTasks.class.getDeclaredMethods();

        for (Method m : methods) {
            if (m.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed role = m.getAnnotation(RoleAllowed.class);
                if (role.value().equals(currentUserRole)) {
                    m.invoke(tasks);
                } else {
                    System.out.println("Access Denied for method: " + m.getName());
                }
            } else {
                m.invoke(tasks);
            }
        }
    }
}
