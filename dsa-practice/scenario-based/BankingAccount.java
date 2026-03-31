abstract class BankAccount {
    private final String accountNumber;
    private final double balance;

    protected BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public final String getAccountNumber() {
        return accountNumber;
    }

    public final double getBalance() {
        return balance;
    }
    public abstract double calculateFee();
}
class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public double calculateFee() {
        return getBalance() * 0.005; 
    }
}
class CheckingAccount extends BankAccount {

    public CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public double calculateFee() {
        return getBalance() < 1000 ? 1.0 : 0.0;
    }
}
public class BankingAccount {
    public static void main(String[] args) {

        BankAccount savings = new SavingsAccount("12345", 1000.0);
        System.out.printf("%.2f%n", savings.calculateFee());

        BankAccount s2 = new SavingsAccount("111", 500);
        System.out.printf("%.2f%n", s2.calculateFee()); 

        BankAccount c1 = new CheckingAccount("222", 1500);
        System.out.printf("%.2f%n", c1.calculateFee()); 

        BankAccount c2 = new CheckingAccount("333", 500);
        System.out.printf("%.2f%n", c2.calculateFee()); 
    }
}

