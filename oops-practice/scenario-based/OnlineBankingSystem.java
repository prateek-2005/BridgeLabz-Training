import java.util.*;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}

abstract class Account {
    protected String accountNumber;
    protected double balance;
    protected List<String> transactions = new ArrayList<>();

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        transactions.add("Account opened with balance ₹" + balance);
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited ₹" + amount);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException("Insufficient balance in " + accountNumber);
        }
        balance -= amount;
        transactions.add("Withdrawn ₹" + amount);
    }

    public void addInterest() {
        double interest = calculateInterest();
        balance += interest;
        transactions.add("Interest added ₹" + interest);
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public abstract double calculateInterest();
    public abstract String getAccountType();
}

class SavingsAccount extends Account {
    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public double calculateInterest() {
        return balance * 0.04;
    }

    public String getAccountType() {
        return "Savings";
    }
}

class CurrentAccount extends Account {
    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public double calculateInterest() {
        return balance * 0.12;
    }

    public String getAccountType() {
        return "Current";
    }
}

interface BankService {
    void createAccount(Account account);
    double checkBalance(String accountNumber) throws AccountNotFoundException;
    void transfer(String fromAcc, String toAcc, double amount)
            throws InsufficientBalanceException, AccountNotFoundException;
    void addInterest(String accountNumber) throws AccountNotFoundException;
    void showStatement(String accountNumber) throws AccountNotFoundException;
}

class BankServiceImplement implements BankService {
    private Map<String, Account> accounts = new HashMap<>();

    public void createAccount(Account account) {
        accounts.put(account.accountNumber, account);
        System.out.println(account.getAccountType() + " account created: " + account.accountNumber);
    }

    private Account getAccount(String accNo) throws AccountNotFoundException {
        Account acc = accounts.get(accNo);
        if (acc == null) {
            throw new AccountNotFoundException("Account not found: " + accNo);
        }
        return acc;
    }

    public double checkBalance(String accountNumber) throws AccountNotFoundException {
        return getAccount(accountNumber).getBalance();
    }

    public void transfer(String fromAcc, String toAcc, double amount)
            throws InsufficientBalanceException, AccountNotFoundException {

        Account sender = getAccount(fromAcc);
        Account receiver = getAccount(toAcc);

        sender.withdraw(amount);
        receiver.deposit(amount);

        sender.transactions.add("Transferred ₹" + amount + " to " + toAcc);
        receiver.transactions.add("Received ₹" + amount + " from " + fromAcc);

        System.out.println("Transfer successful: ₹" + amount);
    }

    public void addInterest(String accountNumber) throws AccountNotFoundException {
        Account acc = getAccount(accountNumber);
        acc.addInterest();
        System.out.println("Interest credited to " + accountNumber);
    }

    public void showStatement(String accountNumber) throws AccountNotFoundException {
        Account acc = getAccount(accountNumber);
        System.out.println("Statement for " + accountNumber);
        for (String t : acc.getTransactions()) {
            System.out.println(t);
        }
        System.out.println("Final Balance ₹" + acc.getBalance());
    }
}

public class OnlineBankingSystem {
    public static void main(String[] args) {
        BankService bank = new BankServiceImplement();
        bank.createAccount(new SavingsAccount("A101", 5000));
        bank.createAccount(new CurrentAccount("A102", 3000));
        try {
            bank.transfer("A101", "A102", 1000);
            bank.addInterest("A101");
            bank.addInterest("A102");

            System.out.println("Balance A101 ₹" + bank.checkBalance("A101"));
            System.out.println("Balance A102 ₹" + bank.checkBalance("A102"));

            bank.showStatement("A101");
            bank.showStatement("A102");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
