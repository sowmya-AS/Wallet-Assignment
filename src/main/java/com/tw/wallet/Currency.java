package com.tw.wallet;

public enum Currency {
    RUPEE(1.0),
    DOLLAR(74.85);

    public final double conversionFactor;

    Currency(double conversionFactor) {

        this.conversionFactor = conversionFactor;
    }

    public static double convertToBaseCurrency(double amount, Currency currencyType) {
        return amount * currencyType.conversionFactor;
    }

    public static double convertToPreferredCurrency(double amount, Currency currencyType) {
        return amount / currencyType.conversionFactor;
    }
}
