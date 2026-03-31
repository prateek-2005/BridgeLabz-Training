package digital_wallet_system;

public interface TransferService {
    void transfer(Wallet from, Wallet to, double amount) throws InsufficientBalanceException;
}

