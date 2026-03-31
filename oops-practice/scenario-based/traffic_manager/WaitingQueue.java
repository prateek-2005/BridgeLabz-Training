package traffic_manager;
import java.util.LinkedList;
import java.util.Queue;

public class WaitingQueue {
    private Queue<String> queue;
    private int capacity;

    public WaitingQueue(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
    }

    public void enqueue(String car) {
        if (queue.size() == capacity) {
            System.out.println("Queue Overflow! " + car + " cannot enter.");
        } else {
            queue.add(car);
            System.out.println(car + " added to waiting queue.");
        }
    }

    public String dequeue() {
        if (queue.isEmpty()) {
            System.out.println("Queue Underflow! No cars waiting.");
            return null;
        }
        return queue.poll();
    }
}

