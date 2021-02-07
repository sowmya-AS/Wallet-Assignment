package com.tw.wallet;

public class Money {
    final double value;
    final Currency currencyType;

    public Money(double value, Currency currencyType) {
        this.value = value;
        this.currencyType = currencyType;
    }
}
