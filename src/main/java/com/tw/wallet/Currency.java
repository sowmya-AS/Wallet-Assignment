package com.tw.wallet;

public enum Currency {
    RUPEE(74.85);

    public final double conversionFactor;

    Currency(double conversionFactor) {

        this.conversionFactor = conversionFactor;
    }
}
