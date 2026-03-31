import java.util.*;

class Pump {
    int petrol, distance;

    Pump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

public class CircularTour {

    public static int findStartingPump(Pump[] pumps, int n) {

        Queue<Integer> queue = new LinkedList<>();
        int balance = 0;
        int i = 0;
        while (i < n) {
            balance += pumps[i].petrol - pumps[i].distance;
            queue.offer(i);
            while (!queue.isEmpty() && balance < 0) {
                int front = queue.poll();
                balance -= (pumps[front].petrol - pumps[front].distance);
            }
            i++;
        }
        if (queue.isEmpty()) {
        	return -1;
        }

        return queue.peek(); 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of petrol pumps: ");
        int n = sc.nextInt();
        Pump[] pumps = new Pump[n];
        System.out.println("Enter petrol and distance for each pump:");
        for (int i = 0; i < n; i++) {
            System.out.print("Pump " + i + " petrol: ");
            int petrol = sc.nextInt();
            System.out.print("Pump " + i + " distance: ");
            int distance = sc.nextInt();
            pumps[i] = new Pump(petrol, distance);
        }
        int result = findStartingPump(pumps, n);
        if (result == -1) {
        	System.out.println("No possible circular tour.");
        }    
        else {
        	System.out.println("Start from pump index: " + result);
        }
        sc.close();
    }
}

