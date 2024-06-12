package com.odisea.coinconversor.modelos;

import com.google.gson.annotations.SerializedName;

public class Moneda {
    @SerializedName("conversion_rates")
    private ConversionRates conversionRates;

    //Setters
    public void setConversionRates(com.odisea.coinconversor.modelos.ConversionRates conversionRates) {
        this.conversionRates = conversionRates;
    }

    //Getters

    public com.odisea.coinconversor.modelos.ConversionRates getConversionRates() {
        return conversionRates;
    }

    //Metodos ci
    @Override
    public String toString() {
        return conversionRates+"\n";
    }
}
