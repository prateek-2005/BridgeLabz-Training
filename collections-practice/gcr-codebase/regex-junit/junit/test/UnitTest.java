package com.example.junit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class UnitTest {

    @Test
    public void Test_Deposit_ValidAmount() {
        Program account = new Program(100.0);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance());
    }

    @Test
    public void Test_Deposit_NegativeAmount() {
        Program account = new Program(100.0);

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> account.deposit(-20.0)
        );

        assertEquals("Deposit amount cannot be negative", exception.getMessage());
    }

    @Test
    public void Test_Withdraw_ValidAmount() {
        Program account = new Program(200.0);
        account.withdraw(75.0);
        assertEquals(125.0, account.getBalance());
    }

    @Test
    public void Test_Withdraw_InsufficientFunds() {
        Program account = new Program(50.0);

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(100.0)
        );

        assertEquals("Insufficient funds.", exception.getMessage());
    }
}
