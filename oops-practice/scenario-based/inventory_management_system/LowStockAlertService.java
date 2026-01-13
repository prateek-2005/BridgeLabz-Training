package inventory_management_system;

public class LowStockAlertService implements AlertService {
	@Override
	public void sendAlert(Product product) {
		System.out.println("Low Stock Of This Product: "+product.getName()+" And Quantity Remaining: "+product.getQuantity());
	}
}
