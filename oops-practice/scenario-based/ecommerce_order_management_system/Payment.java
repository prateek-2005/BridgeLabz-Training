package ecommerce_order_management_system;
public class PaymentFailedException extends Exception{
	public PaymentFailedException(String message) {
		super(message);
	}
}

interface Payment {
	void pay(double amount) throws PaymentFailedException;
}
class CardPayment implements Payment{
	@Override
	public void pay(double amount) throws PaymentFailedException {
		if(amount>20000) {
			throw new PaymentFailedException("Amount is greater than card limit");
		}
		else {
			System.out.println("Amount Of Rs."+amount+" paid using card.");
		}
	}
}
class Upi implements Payment{
	@Override
	public void pay(double amount) throws PaymentFailedException {
		if(amount>10000) {
			throw new PaymentFailedException("Amount is greater than upi limit");
		}
		else {
			System.out.println("Amount Of Rs."+amount+" paid using upi.");
		}
	}
}
class Wallet implements Payment{
	@Override
	public void pay(double amount) throws PaymentFailedException {
		if(amount>5000) {
			throw new PaymentFailedException("Insufficient Wallet Balance");
		}
		else {
			System.out.println("Amount Of Rs."+amount+" paid using wallet.");
		}
	}
}