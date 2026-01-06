abstract class BankAccount{
	private String accountNumber;
	private String holderName;
	private double balance;
	BankAccount(String accountNumber,String holderName,double balance){
		setAccountNumber(accountNumber);
		setHolderName(holderName);
		setBalance(balance);
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber=accountNumber;
	}
	public void setHolderName(String holderName) {
		this.holderName=holderName;
	}
	public void setBalance(double balance) {
		this.balance=balance;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public String getHolderName() {
		return holderName;
	}
	public double getBalance(){
		return balance;
	}
	public void deposit(double amount) {
		balance+=amount;
	}
	public void withdraw(double amount) {
		if(amount<=balance) {
			balance-=amount;
		}
		else {
			System.out.println("Amount can't be withdraw");
		}
	}
	abstract double calculateInterest();
}
interface Loanable{
	void applyForLoan(double amount);
	boolean calculateLoanElgibility();
}
class SavingsAccount extends BankAccount implements Loanable{
	SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
	@Override
	double calculateInterest() {
		return getBalance()*0.08;
	}
	@Override
	public void applyForLoan(double amount) {
		System.out.println("Loan Applied Successfully For Amount Of "+amount);
	}
	@Override
	public boolean calculateLoanElgibility() {
		return getBalance()>20000;
	}
}
class CurrentAccount extends BankAccount implements Loanable{
	CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
	@Override
    double calculateInterest() {
        return getBalance() * 0.10;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan Applied Successfully For Ammount Of "+amount);
    }

    @Override
    public boolean calculateLoanElgibility() {
        return getBalance() > 50000;
    }
}
class Display{
	static void display(BankAccount account) {
		System.out.println("Account Number: "+account.getAccountNumber());
		System.out.println("Account Holder: "+account.getHolderName());
		System.out.println("Account Balance: "+account.getBalance());
		System.out.println("Interest: "+account.calculateInterest());
		if(account instanceof Loanable) {
			Loanable loan=(Loanable) account;
			System.out.println("Elgible For Loan: "+ (loan.calculateLoanElgibility()==true?"YES":"NO"));
		}
		System.out.println("-----------END--------");
	}
}
public class BankingSystem {

	public static void main(String[] args) {
		BankAccount account1=new SavingsAccount("SA875246","Prateek",20000);
		BankAccount account2=new CurrentAccount("CA348752","Shyam",40000);
		Display.display(account1);
		Display.display(account2);
		account1.withdraw(5000);
		account1.deposit(80000);
		account2.withdraw(10000);
		account2.deposit(15000);
		Display.display(account1);
		Display.display(account2);
	}

}
