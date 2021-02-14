package com.tw.wallet;

import static com.tw.wallet.Money.totalMoney;

public class Wallet {
    public double balanceAmount = 0;

    public void take(Money money) throws InsufficientBalanceInWalletException {
        if (money.checkAvailable(balanceAmount)) {
            throw new InsufficientBalanceInWalletException();
        }
        balanceAmount = money.withdraw(balanceAmount);
    }

    public void put(Money money) {
        balanceAmount = money.add(balanceAmount);
    }

    public double totalBalanceInPreferredCurrency(Currency currencyType) {
        return totalMoney(balanceAmount,currencyType);
    }
}
