import java.util.*;
class BankAccount {
    String accountHolder;
    int accountNumber;
    double balance;
    BankAccount(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
        displayBalance();
    }
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdraw amount is : " + amount);
            displayBalance();
        } else {
            System.out.println("Insufficient balance");
        }
    }
    void displayBalance() {
        System.out.println("Current balance: " + balance);
    }

}
public class ATM {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Accout Holder: ");
		String accountHolder=sc.nextLine();
		System.out.println("Enter Accout Number: ");
		int accountNumber=sc.nextInt();
		System.out.println("Enter Balance: ");
		double balance=sc.nextDouble();
		System.out.println();
		BankAccount account=new BankAccount(accountHolder,accountNumber,balance);
		System.out.println(account.accountHolder);
        account.displayBalance();
        System.out.println("Amount To be Deposited: ");
        int Deposited=sc.nextInt();
        account.deposit(Deposited);
        System.out.println("Amount To be Withdraw: ");
        int Withdraw=sc.nextInt();
        account.withdraw(Withdraw);
        System.out.println("Whole money withdraw: ");
        int rem=sc.nextInt();
        account.withdraw(rem);
        sc.close();
	}

}
