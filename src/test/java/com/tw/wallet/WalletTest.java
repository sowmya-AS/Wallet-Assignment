package com.tw.wallet;

import org.junit.jupiter.api.Test;

import static com.tw.wallet.Currency.RUPEE;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WalletTest {
    @Test
    void shouldReturnTrueIfSpecifiedAmountHasBeenWithdrawnFromTheWallet() {

        Money money = new Money(100, RUPEE);
        Wallet wallet = new Wallet();
        wallet.deposit(money);
        Money newMoney = new Money(50, RUPEE);


        boolean status = wallet.withdraw(newMoney);

        assertTrue(status);
    }

    @Test
    void shouldReturnFalseIfSpecifiedAmountCannotBeWithdrawnFromTheWallet() {
        Money money = new Money(40, RUPEE);
        Wallet wallet = new Wallet();
        wallet.deposit(money);
        Money newMoney = new Money(50, RUPEE);


        boolean status = wallet.withdraw(newMoney);

        assertFalse(status);
    }


}
