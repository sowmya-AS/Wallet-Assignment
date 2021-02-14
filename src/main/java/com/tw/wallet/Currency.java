package com.tw.wallet;

public enum Currency {
    RUPEE(1.0);

    public final double conversionFactor;

    Currency(double conversionFactor) {

        this.conversionFactor = conversionFactor;
    }

    public static double convertToBaseCurrency(double amount, Currency currencyType) {
        return amount * currencyType.conversionFactor;
    }
}
