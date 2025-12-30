import java.util.*;
class MovieName{
	String movieName;
	String seatNumber;
	double price;
	boolean isBooked;
	MovieName(String movieName,String seatNumber,double price){
		this.movieName=movieName;
		this.seatNumber=seatNumber;
		this.price=price;
		this.isBooked=false;
	}
	void bookTicket(String movieName, String seatNumber, double price) {
        if (!isBooked) {
            this.isBooked = true;
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
        } else {
            System.out.println("House full!!! sorry..... Ticket already booked");
        }
    }
    void displayTicket() {
        if (!isBooked) {
            System.out.println("Ticket have not booked yet....");
        } else {
            System.out.println("Price: $" + price);
        }
    }	
}
public class MovieTicketBookingSystem {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String movieName=sc.nextLine();
		String seatNumber=sc.nextLine();
		double price=sc.nextDouble();
		MovieName ticket=new MovieName(movieName,seatNumber,price);
		ticket.displayTicket();
		ticket.bookTicket(movieName, seatNumber, price);
		ticket.bookTicket(movieName, seatNumber, price);
		ticket.bookTicket(movieName, seatNumber, price);
		ticket.displayTicket();
		sc.close();
	}

}
