class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn:" + amount);
        } else {
            System.out.println("insufficient funds.");
        }
    }
    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Balance: $" + balance);
        System.out.println();
    }
}
class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }
    public void displaySavingsDetails() {
        System.out.println("Savings Account Number: " + accountNumber);  
        System.out.println("Savings Account Holder: " + accountHolder);   
        System.out.println("Account Balance: $" + getBalance()); 
        System.out.println();
    }
}
public class BankAccountManagement {
    public static void main(String[] args) {
        BankAccount account= new BankAccount("ACC12345","Prateek",1000.0);
        account.displayDetails();
        account.deposit(500);
        account.withdraw(200);
        System.out.println("Updated Balance: $" + account.getBalance());
        account.displayDetails();
        SavingsAccount savAcc = new SavingsAccount("SAV67890", "Sumit",5000.0);
        savAcc.displaySavingsDetails();
    }
}