package multithreading;
import java.time.LocalDateTime;

class BankAccount {
    private int balance = 10000;

    public synchronized void withdraw(String customer, int amount) {
        System.out.println("[" + customer + "] Attempting to withdraw " + amount +
                " at " + LocalDateTime.now());

        if (balance >= amount) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            balance -= amount;
            System.out.println("Transaction successful: " + customer +
                    ", Amount: " + amount +
                    ", Balance: " + balance);
        } else {
            System.out.println("Transaction failed: " + customer +
                    ", Insufficient balance");
        }
    }
}

class Transaction implements Runnable {
    private BankAccount account;
    private int amount;
    private String customerName;

    public Transaction(BankAccount account, String customerName, int amount) {
        this.account = account;
        this.amount = amount;
        this.customerName = customerName;
    }

    @Override
    public void run() {
        System.out.println("Thread State before execution: " +
                Thread.currentThread().getState());
        account.withdraw(customerName, amount);
    }
}

public class BankingSystem {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        new Thread(new Transaction(account, "Customer-1", 3000), "Customer-1").start();
        new Thread(new Transaction(account, "Customer-2", 4000), "Customer-2").start();
        new Thread(new Transaction(account, "Customer-3", 2000), "Customer-3").start();
        new Thread(new Transaction(account, "Customer-4", 5000), "Customer-4").start();
        new Thread(new Transaction(account, "Customer-5", 1500), "Customer-5").start();
    }
}
