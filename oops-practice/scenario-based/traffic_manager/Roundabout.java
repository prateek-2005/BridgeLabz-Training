package traffic_manager;

public class Roundabout {
    private Vehicle tail;

    public Roundabout() {
        tail = null;
    }

    public void addVehicle(String number) {
        Vehicle newNode = new Vehicle(number);

        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println(number + " entered the roundabout.");
    }

    public void removeVehicle() {
        if (tail == null) {
            System.out.println("Roundabout is empty.");
            return;
        }

        Vehicle head = tail.next;

        if (head == tail) {
            System.out.println(head.number + " exited the roundabout.");
            tail = null;
        } else {
            System.out.println(head.number + " exited the roundabout.");
            tail.next = head.next;
        }
    }

    public void display() {
        if (tail == null) {
            System.out.println("Roundabout is empty.");
            return;
        }

        Vehicle temp = tail.next;
        System.out.print("Roundabout: ");
        do {
            System.out.print(temp.number + " -> ");
            temp = temp.next;
        } while (temp != tail.next);
        System.out.println("(circular)");
    }
}

