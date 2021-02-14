package com.tw.wallet;

import java.util.Objects;

import static com.tw.wallet.Currency.convertToBaseCurrency;
import static com.tw.wallet.Currency.convertToPreferredCurrency;

public class Money {
    final double value;
    final Currency currencyType;

    public Money(double value, Currency currencyType) {
        this.value = value;
        this.currencyType = currencyType;
    }

    public boolean checkAvailable(double amount) {
        return (amount < getValueOfMoneyInBaseCurrency(value, currencyType));
    }

    public double withdraw(double amount) {
        amount -= getValueOfMoneyInBaseCurrency(value, currencyType);
        return amount;
    }

    private double getValueOfMoneyInBaseCurrency(double amount, Currency currencyType) {
        return convertToBaseCurrency(amount, currencyType);
    }

    public double add(double amount) {
        amount += getValueOfMoneyInBaseCurrency(value, currencyType);
        return amount;
    }

    public static double totalMoney(double balanceMoney, Currency currency) {
        return convertToPreferredCurrency(balanceMoney, currency);
    }

   @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Money amount = (Money) other;
        return (convertToBaseCurrency(value, currencyType) == convertToBaseCurrency(amount.value, currencyType));
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
