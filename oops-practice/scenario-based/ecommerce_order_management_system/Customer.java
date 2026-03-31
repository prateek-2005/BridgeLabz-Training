package ecommerce_order_management_system;

class Customer {
	private String customerId;
	private String customerName;
	Customer(String customerId,String customerName){
		this.customerId=customerId;
		this.customerName=customerName;
	}
	String getId() {
		return customerId;
	}
	String getName(){
		return customerName;
	}
	void display() {
		System.out.println("Customer Name: "+customerName);
	}
}
