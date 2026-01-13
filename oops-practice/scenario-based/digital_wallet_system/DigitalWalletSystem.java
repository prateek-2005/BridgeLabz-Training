package digital_wallet_system;

public class DigitalWalletSystem {
	public static void main(String[] args) {

        WalletService service = new WalletService();

        User u1 = new User(1, "Prateek");
        User u2 = new User(2, "Dipanshu");

        service.createWallet(u1);
        service.createWallet(u2);

        service.addMoney(1, 500);
        service.addMoney(2, 200);

        service.withdrawMoney(1, 100);
        service.transfer(1, 2, 200, new WalletTransfer());
        service.transfer(1, 2, 50, new BankTransfer());

        service.showTransactions();
    }
}
