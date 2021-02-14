package com.tw.wallet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

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
}
