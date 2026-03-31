package ecommerce_order_management_system;
public class ECommerceOrderManagementSystem {
    public static void main(String[] args) {
        Product p1= new Product("P101", "SmartPhone", 2,4000);
        p1.displayProduct();
        Product p2= new Product("P105", "Watch",3,1500);
        p2.displayProduct();
        Product p3=new Product("P124","TV",1,8000);
        p3.displayProduct();
        Customer c1 = new Customer("C101", "Prateek");
        Order order1 = new Order(p1, c1,"");
        order1.placeOrder();         
        order1.trackOrder();
        Payment payment = new CardPayment();
        order1.makePayment(payment);  
        order1.trackOrder();
        System.out.println("------Next Order Details------");
        Customer c2= new Customer("C110", "Dipanshu");
        Order order2 = new Order(p2,c2,"");
        order2.placeOrder();         
        order2.trackOrder();  
        order2.cancelOrder();
        Payment payment2= new Upi();
        order2.makePayment(payment2);
        order2.trackOrder();
    }
}

