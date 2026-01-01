class BankAccount {
    String accountHolderName;
    final String accountNumber;
    double balance;
    static int totalAccounts = 0;
    BankAccount(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++;
    }
    static void showTotalAccounts() {
        System.out.println("Total number of accounts: " + totalAccounts);
    }
    void display() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
        System.out.println();
    }
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.err.println("Insufficient balance or invalid amount.");
        }
    }
}

public class BankAccountSystem {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Lynda Princy", "ACC12345", 1000.00);
        BankAccount account2 = new BankAccount("Prince Danish", "ACC67890", 500.00);
        System.out.println("Initial Account Details:");
        account1.display();
        account2.display();
        BankAccount.showTotalAccounts();
        System.out.println("Transactions on Account 1:");
        account1.deposit(200);
        account1.withdraw(150);
        account1.display();
        System.out.println("Transactions on Account 2:");
        account2.deposit(100);
        account2.withdraw(800);
        account2.display();
    }
}