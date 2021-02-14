package com.tw.wallet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static com.tw.wallet.Currency.DOLLAR;
import static com.tw.wallet.Currency.RUPEE;
import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {

    @Test
    void shouldReturnTrueIfSpecifiedAmountHasBeenWithdrawnFromTheWallet() {
        Money money = new Money(100, RUPEE);
        Wallet wallet = new Wallet();
        wallet.put(money);
        Money newMoney = new Money(50, RUPEE);

        Executable executable = () -> wallet.take(newMoney);

        assertDoesNotThrow(executable);
    }

    @Test
    void shouldThrowMoneyInsufficientBalanceInWalletExceptionIfSpecifiedAmountCannotBeWithdrawnFromTheWallet() {
        Money money = new Money(40, RUPEE);
        Wallet wallet = new Wallet();
        wallet.put(money);
        Money newMoney = new Money(50, RUPEE);

        Executable executable = () -> wallet.take(newMoney);

        assertThrows(InsufficientBalanceInWalletException.class, executable);
    }

    @Test
    void shouldReturnTotalInINRWhenMyWalletHasFiftyRupeesAndOneDollar() {
        Money rupeeMoney = new Money(50, RUPEE);
        Money dollarMoney = new Money(1, DOLLAR);
        Wallet wallet = new Wallet();
        wallet.put(rupeeMoney);
        wallet.put(dollarMoney);

        double totalAmountInINR = wallet.totalBalanceInPreferredCurrency(RUPEE);

        assertEquals(124.85, totalAmountInINR);
    }

    @Test
    void shouldReturnBalanceAmountInUSDWhenMultipleDepositsAreMade() {
        Money rupeeMoney = new Money(74.85, RUPEE);
        Money dollarMoney = new Money(1, DOLLAR);
        Money anotherRupeeMoney = new Money(149.7, RUPEE);
        Wallet wallet = new Wallet();
        wallet.put(rupeeMoney);
        wallet.put(dollarMoney);
        wallet.put(anotherRupeeMoney);
        double totalAmountInUSD = wallet.totalBalanceInPreferredCurrency(DOLLAR);
        assertEquals(4.0, totalAmountInUSD, 0.1);
    }
}
