public class PerformanceService {
    public String longRunningTask() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Task Completed";
    }
}
