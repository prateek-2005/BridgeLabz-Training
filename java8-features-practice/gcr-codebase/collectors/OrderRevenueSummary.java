package collectors;
import java.util.*;
import java.util.stream.Collectors;

class Order {
    String customerName;
    double totalAmount;

    Order(String customerName, double totalAmount) {
        this.customerName = customerName;
        this.totalAmount = totalAmount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}

public class OrderRevenueSummary {
    public static void main(String[] args) {

        List<Order> orders = Arrays.asList(
            new Order("Amit", 2500.50),
            new Order("Ravi", 1800.00),
            new Order("Amit", 1200.75),
            new Order("Neha", 3000.00),
            new Order("Ravi", 700.25)
        );
        Map<String, Double> revenueByCustomer =
            orders.stream()
                  .collect(Collectors.groupingBy(
                      Order::getCustomerName,
                      Collectors.summingDouble(Order::getTotalAmount)
                  ));

        System.out.println(revenueByCustomer);
    }
}
