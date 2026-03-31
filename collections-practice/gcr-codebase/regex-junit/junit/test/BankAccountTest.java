import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
public class BankAccountTest {
    BankAccount account;
    @BeforeEach
    void setUp() {
        account = new BankAccount(1000.0);
    }
    @Test
    void testDepositIncreasesBalance() {
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance());
    }
    @Test
    void testWithdrawDecreasesBalance() {
        account.withdraw(300.0);
        assertEquals(700.0, account.getBalance());
    }
    @Test
    void testWithdrawFailsWhenInsufficientFunds() {
        Exception exception = assertThrows(
                IllegalStateException.class,
                () -> account.withdraw(2000.0)
        );
        assertEquals("Insufficient funds", exception.getMessage());
    }
    @Test
    void testInvalidDepositAmount() {
        assertThrows(
                IllegalArgumentException.class,
                () -> account.deposit(-100)
        );
    }
}
