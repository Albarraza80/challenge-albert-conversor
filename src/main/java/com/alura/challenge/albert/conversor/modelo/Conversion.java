package com.alura.challenge.albert.conversor.modelo;

import com.google.gson.annotations.SerializedName;

public class Conversion {

    @SerializedName("conversion_result")
    private double resultadoConversion;

    @SerializedName("time_last_update_utc")
    private String fechaDeConsulta;

    @SerializedName("conversion_rate")
    private double tasaDeConversion;

    public double getTasaDeConversion() {
        return tasaDeConversion;
    }

    public void setTasaDeConversion(double tasaDeConversion) {
        this.tasaDeConversion = tasaDeConversion;
    }

    public String getFechaDeConsulta() {
        return fechaDeConsulta;
    }

    public void setFechaDeConsulta(String fechaDeConsulta) {
        this.fechaDeConsulta = fechaDeConsulta;
    }

    public double getResultadoConversion() {
        return resultadoConversion;
    }

    public void setResultadoConversion(double resultadoConversion) {
        this.resultadoConversion = resultadoConversion;
    }
}
