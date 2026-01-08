class ProcessNode {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    ProcessNode next;

    ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime; // for round-robin tracking
        this.priority = priority;
    }
}

public class RoundRobinScheduler {
    ProcessNode head = null;
    ProcessNode tail = null;
    public void addProcess(ProcessNode node) {
        if (head == null) {
            head = tail = node;
            node.next = head; 
        } else {
            tail.next = node;
            tail = node;
            tail.next = head;
        }
    }
    public void removeProcess(int processId) {
        if (head == null) {
            System.out.println("No processes to remove.");
            return;
        }

        ProcessNode temp = head;
        ProcessNode prev = tail;

        while (true) {
            if (temp.processId == processId) {
                if (head == tail) {
                    head = tail = null;
                } else if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else if (temp == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Process " + processId + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
            if (temp == head) break;
        }

        System.out.println("Process not found.");
    }
    public void displayAllProcesses() {
        if (head == null) {
            System.out.println("No processes in queue.");
            return;
        }
        ProcessNode temp = head;
        System.out.println("Processes in circular queue:");
        while (true) {
            System.out.println("ID: " + temp.processId + ", Burst: " + temp.burstTime + ", Priority: " + temp.priority);
            temp = temp.next;
            if (temp == head) break;
        }
    }
    public void simulateRoundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int totalProcesses = 0;
        ProcessNode temp = head;
        do {
            totalProcesses++;
            temp = temp.next;
        } while (temp != head);

        int[] waitingTime = new int[totalProcesses + 1]; // processId as index
        int[] turnAroundTime = new int[totalProcesses + 1];

        int completed = 0;
        int currentTime = 0;
        ProcessNode current = head;

        System.out.println("\n--- Round-Robin Execution ---");
        while (completed < totalProcesses) {
            if (current.remainingTime > 0) {
                int execTime = Math.min(current.remainingTime, timeQuantum);
                System.out.println("Process " + current.processId + " executed for " + execTime + " units.");
                current.remainingTime -= execTime;
                currentTime += execTime;

                if (current.remainingTime == 0) {
                    completed++;
                    turnAroundTime[current.processId] = currentTime;
                    waitingTime[current.processId] = turnAroundTime[current.processId] - current.burstTime;
                }
            }
            current = current.next;
        }
        double totalWT = 0, totalTAT = 0;
        for (int i = 1; i <= totalProcesses; i++) {
            totalWT += waitingTime[i];
            totalTAT += turnAroundTime[i];
        }

        System.out.println("\nAverage Waiting Time: " + (totalWT / totalProcesses));
        System.out.println("Average Turn-Around Time: " + (totalTAT / totalProcesses));
    }

    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        scheduler.addProcess(new ProcessNode(1, 10, 2));
        scheduler.addProcess(new ProcessNode(2, 5, 1));
        scheduler.addProcess(new ProcessNode(3, 8, 3));

        System.out.println("Initial Circular Queue:");
        scheduler.displayAllProcesses();

        int timeQuantum = 3;
        scheduler.simulateRoundRobin(timeQuantum);

        scheduler.removeProcess(2);
        System.out.println("\nQueue after removing Process 2:");
        scheduler.displayAllProcesses();
    }
}
