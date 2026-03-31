package multithreading;
class PrintJob implements Runnable {

    private String jobName;
    private int pages;
    private int priority;

    public PrintJob(String jobName, int pages, int priority) {
        this.jobName = jobName;
        this.pages = pages;
        this.priority = priority;
    }

    @Override
    public void run() {
        String priorityLabel;

        if (priority >= 8)
            priorityLabel = "High Priority";
        else if (priority >= 6)
            priorityLabel = "Medium Priority";
        else
            priorityLabel = "Low Priority";

        try {
            for (int i = 1; i <= pages; i++) {
                System.out.println("[" + priorityLabel + "] Printing "
                        + jobName + " - Page " + i + " of " + pages);
                Thread.sleep(100); // 100ms per page
            }
            System.out.println(jobName + " completed.\n");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class PrintShopScheduler {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Starting print jobs...\n");

        long startTime = System.currentTimeMillis();

        Thread t1 = new Thread(new PrintJob("Job1", 10, 5), "Job1");
        Thread t2 = new Thread(new PrintJob("Job2", 5, 8), "Job2");
        Thread t3 = new Thread(new PrintJob("Job3", 15, 3), "Job3");
        Thread t4 = new Thread(new PrintJob("Job4", 8, 6), "Job4");
        Thread t5 = new Thread(new PrintJob("Job5", 12, 7), "Job5");

        t1.setPriority(5);
        t2.setPriority(8);
        t3.setPriority(3);
        t4.setPriority(6);
        t5.setPriority(7);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        long endTime = System.currentTimeMillis();

        System.out.println("All jobs completed in " +
                (endTime - startTime) + "ms");
    }
}
