import java.util.*;
class Vehicle {
	String number;
	Vehicle next;
	public Vehicle(String number) {
		this.number=number;
		this.next=next;
	}
}

class Roundabout {
	private Vehicle tail;
	private int size;
	private int capacity;
	public Roundabout(int capacity) {
		this.capacity=capacity;
		this.tail=null;
		this.size=0;
	}
	public boolean addVehicle(String number) {
		if(size==capacity) {
			return false;
		}
		Vehicle newNode=new Vehicle(number);
		if(tail==null) {
			tail=newNode;
			tail.next=tail;
		}
		else {
			newNode.next=tail.next;
			tail.next=newNode;
			tail=newNode;
		}
		size++;
		return true;
	}
	public String removeVehicle() {
		if(tail==null) {
			return null;
		}
		Vehicle head=tail.next;
		String number=head.number;
		if(head==tail) {
			tail=null;
		}
		else {
			tail.next=head.next;
		}
		size--;
		return number;
	}
	public void display() {
		if(tail==null) {
			System.out.println("Round about empty.");
			return;
		}
		System.out.print("Roundabout: ");
		Vehicle temp=tail.next;
		do {
			System.out.print(temp.number+" -> ");
			temp=temp.next;
		}
		while(temp!=tail.next);
		System.out.println("Back To Start");
	}
	public boolean isFull() {
		return size==capacity;
	}
}

class WaitingQueue {
	private Queue<String> queue;
	private int limit;
	public WaitingQueue(int limit) {
		this.limit=limit;
		queue=new LinkedList<>();
	}
	public void enqueue(String car) {
		if(queue.size()==limit) {
			System.out.println("Queue Overflow: "+car+" cannot enter.");
		}
		else {
			queue.add(car);
			System.out.println(car+" added to queue.");
		}
	}
	public String dequeue() {
		if(queue.isEmpty()) {
			System.out.println("Queue underflow: No cars waiting.");
			return null;
		}
		return queue.poll();
	}
	public boolean isEmpty() {
		return queue.isEmpty();
	}
}
public class TrafficManager {

	public static void main(String[] args) {
		Roundabout roundabout=new Roundabout(4);
		WaitingQueue queue=new WaitingQueue(6);
		queue.enqueue("CAR1");
		queue.enqueue("CAR2");
		queue.enqueue("CAR3");
		queue.enqueue("CAR4");
		queue.enqueue("CAR5");
		for(int i=0;i<5;i++) {
			String car=queue.dequeue();
			if(car!=null) {
				if(!roundabout.addVehicle(car)) {
					System.out.println("Roundabout full, sending back to queue: "+car);
					queue.enqueue(car); 
				}
			}
		}
		roundabout.display();
		System.out.println("Exited: "+roundabout.removeVehicle());
		roundabout.display();
	}

}
