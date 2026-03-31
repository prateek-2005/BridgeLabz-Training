package ecommerce_order_management_system;

class Order {
    private Product product;
    private Customer customer;
    private String status;

    public Order(Product product, Customer customer,String status) {
        this.product = product;
        this.customer = customer;
        this.status = "CREATED"; 
    }
    public void placeOrder() {
        status = "PLACED";
        System.out.println("Order placed for product: " + product.getName());
    }
    public void makePayment(Payment payment) {

        if (status.equals("CANCELLED")) {
            System.out.println("Payment not allowed. Order is already cancelled.");
            return;
        }

        if (status.equals("CONFIRMED")) {
            System.out.println("Payment already completed.");
            return;
        }

        if (!status.equals("PLACED")) {
            System.out.println("Please place order before making payment.");
            return;
        }

        try {
            payment.pay(product.getPrice()*product.getQuantity());
            status = "CONFIRMED";
            System.out.println("Order confirmed for " + customer.getName());

        } catch (PaymentFailedException e) {
            status = "FAILED";
            System.out.println("Payment failed: " + e.getMessage());
        }
    }


    public void cancelOrder() {

        if (status.equals("CANCELLED")) {
            System.out.println("Order is already cancelled.");
            return;
        }
        if (status.equals("CONFIRMED")) {
            status = "CANCELLED";  
            System.out.println("Order cancelled. Amount will be refunded in 3-5 working days.");
        } else {
            status = "CANCELLED";
            System.out.println("Order cancelled successfully");
        }
    }


    public void trackOrder() {
        System.out.println("Current order status: " + status);
    }
}

