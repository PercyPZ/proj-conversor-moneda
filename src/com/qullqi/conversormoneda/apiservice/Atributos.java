package com.qullqi.conversormoneda.apiservice;

import com.qullqi.conversormoneda.apiservice.CodigoMoneda;

public class Atributos {
    private String linkPrincipal;
    private String claveApi;
    private String endpoint;
    private String monedaBase;
    private String monedaDestino;
    private int cantidad;
    private double tasaDeConversion;
    private double resultadoConversion;


    public Atributos(String linkPrincipal, String claveApi, String endpoint, String monedaBase, String monedaDestino, int cantidad) {
        this.linkPrincipal = linkPrincipal;
        this.claveApi = claveApi;
        this.endpoint = endpoint;
        this.monedaBase = monedaBase;
        this.monedaDestino = monedaDestino;
        this.cantidad = cantidad;
    }

    // Constructor que recibe los atributos de la clase de tipo Record llamada "Monedas".
    public Atributos(Monedas monedas) {
        this.monedaBase = monedas.base_code();
        this.monedaDestino = monedas.target_code();
        this.tasaDeConversion = monedas.conversion_rate();
        this.resultadoConversion = monedas.conversion_result();
    }

    public String getLinkPrincipal() {
        return linkPrincipal;
    }

    public void setLinkPrincipal(String linkPrincipal) {
        this.linkPrincipal = linkPrincipal;
    }

    public String getClaveApi() {
        return claveApi;
    }

    public void setClaveApi(String claveApi) {
        this.claveApi = claveApi;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public void setMonedaBase(String monedaBase) {
        if (monedaBase == null || !monedaBase.matches("[a-zA-Z]{3}")) {
            throw new IllegalArgumentException("El código de moneda base debe tener tres letras.\nIntente nuevamente:");
        }
        monedaBase = monedaBase.toUpperCase(); // Devuelve mayúscula.
        if (!CodigoMoneda.esCodigoValido(monedaBase)) {
            throw new IllegalArgumentException("El código de moneda base no es válido.\nDebe ingresar un código de la 'Lista de monedas admitidas por el aplicativo'.");
        }
        this.monedaBase = monedaBase;// Devuelve los caracteres en mayúscula.
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(String monedaDestino) {
        if (monedaDestino == null || !monedaDestino.matches("[a-zA-Z]{3}")) {
            throw new IllegalArgumentException("El código de moneda destino debe tener tres letras.\nIntente nuevamente:");
        }
        monedaDestino = monedaDestino.toUpperCase(); // Devuelve mayúscula.
        if (!CodigoMoneda.esCodigoValido(monedaDestino)) {
            throw new IllegalArgumentException("El código de moneda destino no es válido.\nDebe ingresar un código de la 'Lista de monedas admitidas por el aplicativo'.");
        }
        this.monedaDestino = monedaDestino;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("El valor de la cantidad de moneda base debe ser un número positivo.");
        }
        this.cantidad = cantidad;
    }

    public double getTasaDeConversion() {
        return tasaDeConversion;
    }

    public void setTasaDeConversion(double tasaDeConversion) {
        this.tasaDeConversion = tasaDeConversion;
    }

    public double getResultadoConversion() {
        return resultadoConversion;
    }

    public void setResultadoConversion(double resultadoConversion) {
        this.resultadoConversion = resultadoConversion;
    }

    @Override
    public String toString() {
        return "Moneda base= " + monedaBase +
                "\nMoneda destino= " + monedaDestino +
                "\nTasa de conversión= " + tasaDeConversion +
                "\nResultado de conversión= " + resultadoConversion;
    }
}
