package annotations;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface LogExecutionTime {
}

class Tasks {

    @LogExecutionTime
    public void fastTask() {
        for (int i = 0; i < 100_000; i++);
    }

    @LogExecutionTime
    public void slowTask() throws InterruptedException {
        Thread.sleep(200);
    }
}

public class LoggingMethod {
    public static void main(String[] args) throws Exception {
        Tasks t = new Tasks();
        Method[] methods = Tasks.class.getDeclaredMethods();

        for (Method m : methods) {
            if (m.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                m.invoke(t);
                long end = System.nanoTime();
                System.out.println(m.getName() + " executed in " + (end - start) + " ns");
            }
        }
    }
}
