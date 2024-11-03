package com.qullqi.conversormoneda.principal;

import com.qullqi.conversormoneda.apiservice.ConsultaApi;
import com.qullqi.conversormoneda.historial.HistorialConversiones;
import com.qullqi.conversormoneda.moneda.ListaMoneda;
import com.qullqi.conversormoneda.moneda.Moneda;

import com.qullqi.conversormoneda.mensaje.Mensajes;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        int opcion = 0;
        // Mensaje de bienvenida.
        Mensajes.mensaje1();
        // Uso de ciclo de repetición con while.
        Scanner lectura = new Scanner(System.in);
        while (opcion != 4) {
            // Mensaje de opciones.
            Mensajes.mensaje2();
            opcion = lectura.nextInt();

            switch (opcion) {
                case 1:
                    List<Moneda> monedas = ListaMoneda.ListaDeMonedas();
                    for (Moneda moneda : monedas) {
                        System.out.println(moneda); // Imprime la lista de las monedas admitidas por el aplicativo.
                    }
                    break;
                case 2:
                    ConsultaApi.solicitandoConversion();
                    break;
                case 3:
                    List<String> historial = HistorialConversiones.obtenerHistorial();
                    if (historial.isEmpty()) {
                        System.out.println("No hay conversiones en el historial.");
                    } else {
                        System.out.println("El historial de las conversiones de monedas realizadas, es la siguiente:");
                        historial.forEach(System.out::println);
                    }
                    break;
                case 4:
                    Mensajes.mensaje3();
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo."); // Mensaje para opciones no válidas
            }
        }
    }
}
