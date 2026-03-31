package inventory_management_system;

public class OutOfStockException extends Exception{
	OutOfStockException(String message){
		super(message);
	}
}
