import java.util.*;
public class CircularBuffer {
    static class CircularQueue {
        int[] arr;
        int capacity, size, front, rear;
        CircularQueue(int capacity) {
            this.capacity = capacity;
            arr = new int[capacity];
            front = 0;
            rear = 0;
            size = 0;
        }
        void insert(int x) {
            arr[rear] = x;
            rear = (rear + 1) % capacity;
            if (size < capacity) size++;
            else front = (front + 1) % capacity;
        }
        List<Integer> getBuffer() {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int idx = (front + i) % capacity;
                result.add(arr[idx]);
            }
            return result;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter buffer size: ");
        int n = sc.nextInt();
        CircularQueue buffer = new CircularQueue(n);
        System.out.print("Enter number of insertions: ");
        int m = sc.nextInt();
        System.out.println("Enter elements to insert:");
        for (int i = 0; i < m; i++) {
            buffer.insert(sc.nextInt());
        }
        System.out.println("Buffer: " + buffer.getBuffer());
        sc.close();
    }
}
