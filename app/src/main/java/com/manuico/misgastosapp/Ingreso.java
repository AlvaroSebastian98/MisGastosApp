package com.manuico.misgastosapp;

public class Ingreso {

    private String detalle;
    private Double monto;

    public Ingreso() {
    }

    public Ingreso(String detalle, Double monto) {
        this.detalle = detalle;
        this.monto = monto;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Ingreso{" +
                "detalle='" + detalle + '\'' +
                ", monto=" + monto +
                '}';
    }

}
