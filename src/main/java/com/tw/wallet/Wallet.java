package com.tw.wallet;

import java.util.HashMap;

public class Wallet {
    public double amount;
    HashMap<Currency, Double> moneySet = new HashMap<>();

    public boolean deposit(Money money) {
        if (moneySet.get(money.currencyType) == null) {
        } else {
            amount = moneySet.get(money.currencyType) + money.value;
        }
        moneySet.put(money.currencyType, money.value);
        return true;
    }

    public boolean withdraw(Money newMoney) {
        if (moneySet.containsKey(newMoney.currencyType)) {
            amount = moneySet.get(newMoney.currencyType);
            if (amount > newMoney.value) {
                amount -= newMoney.value;
                moneySet.put(newMoney.currencyType, amount);
                return true;
            }

        }
        return false;
    }
}
