package digital_wallet_system;

public class Wallet {
    private User user;
    private double balance;

    public Wallet(User user) {
        this.user = user;
        this.balance = 0;
    }

    public User getUser() { 
    	return user;
    }
    public double getBalance() {
    	return balance; 
    }

    public void addMoney(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException("Not enough balance!");
        }
        balance -= amount;
    }
}

