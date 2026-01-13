package digital_wallet_system;

public class WalletService {

    private Wallet[] wallets = new Wallet[5];
    private Transaction[] transactions = new Transaction[20];

    private int walletCount = 0;
    private int count = 0;

    public void createWallet(User user) {
        wallets[walletCount++] = new Wallet(user);
        System.out.println("Wallet created for " + user.getName());
    }

    public Wallet findWallet(int userId) {
        for (int i = 0; i < walletCount; i++) {
            if (wallets[i].getUser().getUserId() == userId)
                return wallets[i];
        }
        return null;
    }

    public void addMoney(int userId, double amount) {
        Wallet w = findWallet(userId);
        if (w != null) {
            w.addMoney(amount);
            transactions[count++] = new Transaction("Add Money", amount);
            System.out.println("Money added: ₹" + amount);
        }
    }

    public void withdrawMoney(int userId, double amount) {
        try {
            Wallet w = findWallet(userId);
            w.withdraw(amount);
            transactions[count++] = new Transaction("Withdraw", amount);
            System.out.println("Withdraw successful");
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }

    public void transfer(int fromId, int toId, double amount, TransferService service) {
        try {
            Wallet from = findWallet(fromId);
            Wallet to = findWallet(toId);

            service.transfer(from, to, amount);
            transactions[count++] = new Transaction("Transfer", amount);

        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showTransactions() {
        System.out.println("\nTransaction History:");
        for (int i = 0; i < count; i++) {
            System.out.println(transactions[i]);
        }
    }
}

