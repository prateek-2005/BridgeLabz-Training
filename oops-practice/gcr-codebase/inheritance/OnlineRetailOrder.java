class Order{
    String orderID;
    String orderDate;
    Order(String orderID,String orderDate){
        this.orderID=orderID;
        this.orderDate=orderDate;
    }
    void getOrderStatus(){
        System.out.println("Order ID: "+orderID);
        System.out.println("Order Date: "+orderDate);
        System.out.println();
    }
}
class ShippedOrder extends Order{
    String trackingNumber;
    ShippedOrder(String orderID, String orderDate,String trackingNumber) {
        super(orderID, orderDate);
        this.trackingNumber=trackingNumber;
    }
    void getOrderStatus(){
        System.out.println("Order ID: "+orderID);
        System.out.println("Order Date: "+orderDate);
        System.out.println("Tracking Number: "+trackingNumber);
        System.out.println();
    }
}
class DeliveredOrder extends ShippedOrder{
    String deliveryDate;
    DeliveredOrder(String orderID, String orderDate, String trackingNumber,String deliveryDate) {
        super(orderID, orderDate, trackingNumber);
        this.deliveryDate=deliveryDate;
    }
    void getOrderStatus(){
        System.out.println("Order ID: "+orderID);
        System.out.println("Order Date: "+orderDate);
        System.out.println("Tracking Number: "+trackingNumber);
        System.out.println("Delivery Date: "+deliveryDate);
        System.out.println();
    }
}
public class OnlineRetailOrder {
    public static void main(String[] args) {
        Order order=new Order("OD12345","25-12-2005");
        ShippedOrder shipped=new ShippedOrder((order.orderID), order.orderDate,"TR98765");
        DeliveredOrder delivered=new DeliveredOrder(order.orderID, order.orderDate, shipped.trackingNumber,"05-01-2026");
        order.getOrderStatus();
        shipped.getOrderStatus();
        delivered.getOrderStatus();
    }
}
