package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void deposit_addsAmountToBalance() {
        BankAccount account = new BankAccount(100.0);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 0.001);
    }

    @Test
    void withdraw_subtractsAmountFromBalance() {
        BankAccount account = new BankAccount(100.0);
        account.withdraw(50.0);
        assertEquals(50.0, account.getBalance(), 0.001);
    }

    @Test
    void deposit_negativeAmount_throwsException() {
        BankAccount account = new BankAccount(100.0);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-10.0));
    }

    @Test
    void withdraw_moreThanBalance_throwsException() {
        BankAccount account = new BankAccount(100.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(200.0));
    }

    @Test
    void constructor_negativeBalance_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount(-10.0));
    }
}
