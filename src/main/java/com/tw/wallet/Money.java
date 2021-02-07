package com.tw.wallet;

public class Money {
    private final double value;
    private final Currency currencyType;

    public Money(double value, Currency currencyType) {
        this.value = value;
        this.currencyType = currencyType;
    }
}
