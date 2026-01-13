package digital_wallet_system;

public class WalletTransfer implements TransferService {

    @Override
    public void transfer(Wallet from, Wallet to, double amount)
            throws InsufficientBalanceException {

        from.withdraw(amount);
        to.addMoney(amount);

        System.out.println("Wallet transfer successful: ₹" + amount);
    }
}

