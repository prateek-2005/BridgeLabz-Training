package digital_wallet_system;

public class BankTransfer implements TransferService {

    @Override
    public void transfer(Wallet from, Wallet to, double amount)
            throws InsufficientBalanceException {

        double charge = 10; 
        from.withdraw(amount + charge);
        to.addMoney(amount);

        System.out.println("Bank transfer successful: ₹" + amount + " (Fee ₹10)");
    }
}

