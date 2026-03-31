class BankAccount{
    int accountNumber;
    double balance;
    BankAccount(int accountNumber,double balance){
        this.accountNumber=accountNumber;
        this.balance=balance;
    }
    void displayaccountType(){
        System.out.println("Bank Account");
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Balance: "+balance);
        System.out.println();
    }
}
class SavingsAccount extends BankAccount {
    double interestRate;
    SavingsAccount(int accountNumber, double balance,double interestRate) {
        super(accountNumber, balance);
        this.interestRate=interestRate;
    }
    void displayaccountType(){
        System.out.println("Savings Account");
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Balance: "+balance);
        System.out.println("Interest Rate: "+interestRate);
        System.out.println();
    }
}
class CheckingAccount extends BankAccount{
    double withdrwalLimit;
    CheckingAccount(int accountNumber, double balance,double withdrwalLimit) {
        super(accountNumber, balance);
        this.withdrwalLimit=withdrwalLimit;
    }
    void displayaccountType(){
        System.out.println("Checking Account");
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Balance: "+balance);
        System.out.println("Withdrwal Limit: "+withdrwalLimit);
        System.out.println();
    }
}
class FixedDepositAccount extends BankAccount{
    double fixedRate;
    FixedDepositAccount(int accountNumber, double balance,double fixedRate) {
        super(accountNumber, balance);
        this.fixedRate=fixedRate;
    }
    void displayaccountType(){
        System.out.println("Fixed Deposit Account");
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Balance: "+balance);
        System.out.println("Fixed Deposit Rate: "+fixedRate);
        System.out.println();
    }
}

public class BankAccountTypes {
    public static void main(String[] args) {
        BankAccount account=new BankAccount(6875234,5000);
        SavingsAccount saving=new SavingsAccount(account.accountNumber, account.balance, 5);
        CheckingAccount checking=new CheckingAccount(account.accountNumber, account.balance, 2000);
        FixedDepositAccount fixed=new FixedDepositAccount(account.accountNumber, account.balance, 10);
        account.displayaccountType();
        saving.displayaccountType();
        checking.displayaccountType();
        fixed.displayaccountType();
    }
}
