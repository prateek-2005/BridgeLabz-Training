class HotelBooking{
	String guestName;
	String roomType;
	int nights;
	//Default Constructor
	HotelBooking(){
		this.guestName="guest";
		this.roomType="Deluxe";
		this.nights=2;
	}
	//Parameterized Constructor
	HotelBooking(String guestName,String roomType,int nights){
		this.guestName=guestName;
		this.roomType=roomType;
		this.nights=nights;
	}
	//Copy Constructor
	HotelBooking(HotelBooking booked){
		this.guestName=booked.guestName;
		this.roomType=booked.roomType;
		this.nights=booked.nights;
	}
	void Display() {
		System.out.println("Hotel Booking");
		System.out.println("Guest Name: "+guestName);
		System.out.println("Room Type: "+roomType);
		System.out.println("Total Nights: "+nights);
		System.out.println();
	}
}
public class HotelBookingSystem {

	public static void main(String[] args) {
		System.out.println("Default Constructor: ");
		HotelBooking booked=new HotelBooking();
		booked.Display();
		System.out.println("Parameterized Constructor");
		HotelBooking booked1=new HotelBooking("Prateek","Golden Suite",5);
		booked1.Display();
		System.out.println("Copy Constructor");
		HotelBooking booked2=new HotelBooking(booked1);
		booked2.Display();
	}

}
