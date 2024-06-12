package com.odisea.coinconversor.modelos;

public class ConversionRates {
    private Double USD;
    private Double MXN;
    private Double COP;
    private Double NIO;
    private Double DOP;

    public ConversionRates(Double USD, Double MXN, Double COP, Double NIO, Double DOP) {
        this.USD = USD;
        this.MXN = MXN;
        this.COP = COP;
        this.NIO = NIO;
        this.DOP = DOP;
    }

    public void setUSD(Double USD) {
        this.USD = USD;
    }
    public void setMXN(Double MXN) {
        this.MXN = MXN;
    }
    public void setCOP(Double COP) {
        this.COP = COP;
    }
    public void setNIO(Double NIO) {
        this.NIO = NIO;
    }
    public void setDOP(Double DOP) {
        this.DOP = DOP;
    }

    //Getters
    public Double getUSD() {
        return USD;
    }
    public Double getMXN() {
        return MXN;
    }
    public Double getCOP() {
        return COP;
    }
    public Double getNIO() {
        return NIO;
    }
    public Double getDOP() {
        return DOP;
    }

    //Metodos Ci
    @Override
    public String toString() {
        return  "\nLos Cambios de Moneda se encuentran así hoy:" +
                "\nUSD= " + USD+
                "\nMXN= " + MXN+
                "\nCOP= " + COP+
                "\nNIO= " + NIO+
                "\nDOP= " + DOP;
    }
}
