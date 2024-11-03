package com.qullqi.conversormoneda.apiservice;

import java.util.ArrayList;
import java.util.List;

public class CodigoMoneda {

    private static final List<String> CODIGOS_MONEDA_VALIDOS = new ArrayList<>(List.of("ARS", "BOB", "BRL", "CAD", "CHF", "CLP", "COP", "EUR", "GBP", "MXN", "PEN", "USD"));

    public static boolean esCodigoValido(String codigoMoneda) {
        return CODIGOS_MONEDA_VALIDOS.contains(codigoMoneda);
    }

    public static List<String> obtenerListaCodigosValidos() {
        return CODIGOS_MONEDA_VALIDOS;
    }
}
