package com.qullqi.conversormoneda.moneda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaMoneda {

    // Cambia el tipo de retorno de void a List<Moneda>
    public static List<Moneda> ListaDeMonedas() {

        System.out.println("Lista de monedas admitidas por el aplicativo:");

        List<Moneda> moneda = new ArrayList<>();

        moneda.add(new Moneda("USD", "Dólar estadounidense"));
        moneda.add(new Moneda("ARS", "Peso argentino"));
        moneda.add(new Moneda("BOB", "Boliviano de Bolivia"));
        moneda.add(new Moneda("BRL", "Real brasileño"));
        moneda.add(new Moneda("CAD", "Dólar canadiense"));
        moneda.add(new Moneda("CHF", "Libra esterlina"));
        moneda.add(new Moneda("CLP", "Peso chileno"));
        moneda.add(new Moneda("COP", "Peso colombiano"));
        moneda.add(new Moneda("EUR", "Euro"));
        moneda.add(new Moneda("GBP", "Libra esterlina"));
        moneda.add(new Moneda("MXN", "Peso mexicano"));
        moneda.add(new Moneda("PEN", "Sol peruano"));

        Collections.sort(moneda); // Ordena la lista de monedas alfabéticamente.
        return moneda; // Devuelve la lista de monedas.
    }

}