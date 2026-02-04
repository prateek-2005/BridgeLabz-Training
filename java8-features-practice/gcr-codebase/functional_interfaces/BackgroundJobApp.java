package functional_interfaces;
public class BackgroundJobApp {

    public static void main(String[] args) {
        Runnable backgroundTask = () -> {
            System.out.println("Background task started");
            try {
                Thread.sleep(2000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Background task completed");
        };
        Thread thread = new Thread(backgroundTask);
        thread.start();

        System.out.println("Main thread continues execution");
    }
}
