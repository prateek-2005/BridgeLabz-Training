package multithreading;
import java.time.LocalTime;
import java.util.*;

class TaskRunner extends Thread {

    public TaskRunner(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 1_000_000; i++) {
                int x = i * i;
            }

            Thread.sleep(2000);

        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted");
        }
    }
}

class StateMonitor extends Thread {
    private Thread[] threads;
    private Map<String, Set<Thread.State>> stateHistory = new HashMap<>();

    public StateMonitor(Thread[] threads) {
        this.threads = threads;
        setName("Monitor");
    }

    @Override
    public void run() {
        boolean allTerminated;

        do {
            allTerminated = true;

            for (Thread t : threads) {
                Thread.State state = t.getState();
                String name = t.getName();

                stateHistory.putIfAbsent(name, new HashSet<>());
                stateHistory.get(name).add(state);

                System.out.println("[Monitor] " + name +
                        " is in " + state +
                        " state at " + LocalTime.now());

                if (state != Thread.State.TERMINATED) {
                    allTerminated = false;
                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (!allTerminated);

        System.out.println("\n----- SUMMARY -----");
        for (String name : stateHistory.keySet()) {
            System.out.println("Summary: " + name + " went through "
                    + stateHistory.get(name).size() + " states -> "
                    + stateHistory.get(name));
        }
    }
}

public class ThreadStateMonitoringSystem {
    public static void main(String[] args) {

        TaskRunner t1 = new TaskRunner("Task-1");
        TaskRunner t2 = new TaskRunner("Task-2");

        Thread[] tasks = { t1, t2 };

        StateMonitor monitor = new StateMonitor(tasks);

        monitor.start();
        t1.start();
        t2.start();
    }
}
