package bankAccountApp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void depositMoney_addsAmountToBalance() {
        BankAccount account = new BankAccount(100.0, 500.0, "2026-01-16", null);
        account.depositMoney(50.0);
        assertEquals(150.0, account.getBalance(), 0.001);
    }

    @Test
    void withdrawMoney_returnsTrue_whenValid() {
        BankAccount account = new BankAccount(100.0, 500.0, "2026-01-16", null);
        boolean result = account.withdrawMoney(50.0);
        assertTrue(result);
        assertEquals(50.0, account.getBalance(), 0.001);
    }

    @Test
    void withdrawMoney_returnsFalse_whenAmountIsNegative() {
        BankAccount account = new BankAccount(100.0, 500.0, "2026-01-16", null);
        assertFalse(account.withdrawMoney(-10.0));
        assertEquals(100.0, account.getBalance());
    }

    @Test
    void withdrawMoney_returnsFalse_whenInsufficientBalance() {
        BankAccount account = new BankAccount(100.0, 500.0, "2026-01-16", null);
        assertFalse(account.withdrawMoney(150.0));
    }

    @Test
    void withdrawMoney_returnsFalse_whenExceedsLimit() {
        BankAccount account = new BankAccount(1000.0, 500.0, "2026-01-16", null);
        assertFalse(account.withdrawMoney(600.0));
    }

    @Test
    void withdrawMoney_returnsFalse_whenCumulativeWithdrawalExceedsLimit() {
        BankAccount account = new BankAccount(1000.0, 500.0, "2026-01-16", null);
        account.withdrawMoney(300.0);
        assertFalse(account.withdrawMoney(300.0));
    }

    @Test
    void defaultConstructor_initializesWithZeroValues() {
        BankAccount account = new BankAccount();
        assertEquals(0, account.getBalance());
        assertEquals(0, account.getAccountNumber());
        assertNull(account.getAccountHolder());
    }

    @Test
    void toString_containsAccountDetails() {
        BankAccount account = new BankAccount(100.0, 500.0, "2026-01-16", null);
        account.setAccountNumber(99);
        String result = account.toString();

        assertTrue(result.contains("99"));
        assertTrue(result.contains("100.0"));
        assertTrue(result.contains("2026-01-16"));
    }

    @Test
    void convertToText_returnsFormattedString() {
        BankAccount account = new BankAccount(100.0, 500.0, "2026-01-16", null);
        account.setAccountNumber(1);
        String text = account.convertToText(account);

        assertTrue(text.startsWith("1" + Person.DELIM + "100.0"));
    }

    @Test
    void depositMoney_ignoresNegativeAmount() {
        BankAccount account = new BankAccount(100.0, 500.0, "2026-01-16", null);
        account.depositMoney(-50.0);
        assertEquals(100.0, account.getBalance(), "Balance should not change with negative deposit");
    }
}