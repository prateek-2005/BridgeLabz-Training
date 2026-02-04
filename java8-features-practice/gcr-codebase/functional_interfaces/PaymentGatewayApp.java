package functional_interfaces;
interface PaymentProcessor {

    void pay(double amount);

    default void refund(double amount) {
        System.out.println("Refund of ₹" + amount + " processed (default handler)");
    }
}

class UpiPayment implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }
}

class CardPayment implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card");
    }

    public void refund(double amount) {
        System.out.println("Refund of ₹" + amount + " processed to Credit Card");
    }
}

public class PaymentGatewayApp {

    public static void main(String[] args) {

        PaymentProcessor p1 = new UpiPayment();
        PaymentProcessor p2 = new CardPayment();

        p1.pay(2000);
        p1.refund(500);  

        p2.pay(3000);
        p2.refund(1000);  
    }
}
