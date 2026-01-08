class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;

    TicketNode(int ticketId, String customerName, String movieName,
               String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
    }
}

public class TicketReservationSystem {

    TicketNode head = null;
    TicketNode tail = null;
    int count = 0;
    public void addTicket(TicketNode node) {
        if (head == null) {
            head = tail = node;
            node.next = head;
        } else {
            tail.next = node;
            tail = node;
            tail.next = head;
        }
        count++;
    }

    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        TicketNode temp = head;
        TicketNode prev = tail;

        while (true) {
            if (temp.ticketId == ticketId) {
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
                count--;
                System.out.println("Ticket removed successfully.");
                return;
            }
            prev = temp;
            temp = temp.next;
            if (temp == head) break;
        }

        System.out.println("Ticket not found.");
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        TicketNode temp = head;
        while (true) {
            System.out.println(
                "Ticket ID: " + temp.ticketId +
                ", Customer: " + temp.customerName +
                ", Movie: " + temp.movieName +
                ", Seat: " + temp.seatNumber +
                ", Time: " + temp.bookingTime
            );
            temp = temp.next;
            if (temp == head) break;
        }
    }
    public void searchTicket(String keyword) {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }

        TicketNode temp = head;
        boolean found = false;

        while (true) {
            if (temp.customerName.equalsIgnoreCase(keyword) ||
                temp.movieName.equalsIgnoreCase(keyword)) {

                System.out.println(
                    "Ticket ID: " + temp.ticketId +
                    ", Customer: " + temp.customerName +
                    ", Movie: " + temp.movieName
                );
                found = true;
            }
            temp = temp.next;
            if (temp == head) break;
        }

        if (!found) {
            System.out.println("No matching ticket found.");
        }
    }
    public void countTickets() {
        System.out.println("Total booked tickets: " + count);
    }

    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(new TicketNode(1, "Prateek", "Avatar", "A1", "10:00 AM"));
        system.addTicket(new TicketNode(2, "Ayush", "Avatar", "A2", "10:05 AM"));
        system.addTicket(new TicketNode(3, "Hritik", "Inception", "B1", "11:00 AM"));

        System.out.println("\nAll Tickets:");
        system.displayTickets();

        System.out.println("\nSearch by Movie:");
        system.searchTicket("Avatar");

        system.removeTicket(2);

        System.out.println("\nAfter Removal:");
        system.displayTickets();

        system.countTickets();
    }
}
