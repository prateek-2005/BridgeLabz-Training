package reflection;
import java.lang.reflect.Method;
class Task {
    public void runTask() throws InterruptedException {
        Thread.sleep(200);
    }

    public void quickTask() {
        for (int i = 0; i < 1000000; i++);
    }
}
public class MethodExecution {
    public static void main(String[] args) throws Exception {
        Task obj = new Task();
        Method[] methods = Task.class.getDeclaredMethods();

        for (Method m : methods) {
            long start = System.nanoTime();
            m.invoke(obj);
            long end = System.nanoTime();
            System.out.println(m.getName() + " : " + (end - start) + " ns");
        }
    }
}
