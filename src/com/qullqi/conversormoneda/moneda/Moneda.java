package com.qullqi.conversormoneda.moneda;

public class Moneda implements Comparable<Moneda> {
    private String codigoMoneda;
    private String nombreMoneda;


    public Moneda(String codigoMoneda, String nombreMoneda) {
        if (codigoMoneda.length() != 3) {
            throw new IllegalArgumentException("El código de moneda debe tener tres caracteres.");
        }
        this.codigoMoneda = codigoMoneda.toUpperCase(); // Devuelve el código de moneda en mayúscula.
        if (nombreMoneda == null || nombreMoneda.isEmpty()) {
            throw new IllegalArgumentException("El nombre de la moneda no puede estar vacío.");
        }
        this.nombreMoneda = nombreMoneda.substring(0, 1).toUpperCase() + nombreMoneda.substring(1).toLowerCase(); // Devuelve el priner caracter del nombre de moneda en mayúscula.
    }

    public String getCodigoMoneda() {
        return codigoMoneda;
    }

    public String getNombreMoneda() {
        return nombreMoneda;
    }

    @Override public int compareTo(Moneda otra) {
        return this.codigoMoneda.compareTo(otra.codigoMoneda);
    }

    @Override
    public String toString() {
        return codigoMoneda + " - " + nombreMoneda;
    }
}
