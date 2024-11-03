package com.qullqi.conversormoneda.apiservice;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsultaApi extends Atributos {

    public ConsultaApi(String linkPrincipal, String claveApi, String endpoint, String monedaBase, String monedaDestino, int cantidad) {
        super(linkPrincipal, claveApi, endpoint, monedaBase, monedaDestino, cantidad);
    }


    public static void solicitandoConversion () throws IOException, InterruptedException {

        Scanner lectura = new Scanner(System.in);

        // Instancia de la clase ConsultaApi.
        ConsultaApi consulta = new ConsultaApi("https://v6.exchangerate-api.com/v6/", "a6d0f5318d000943d2aa14e3/", "pair/", "", "", 0 );

        try {
            // Solicita la moneda base y verifica que cumpla con las reglas
            System.out.println("Ingrese la moneda base para ejecutar la conversión.\n (Ejemplo - código de moneda: USD)");
            String monedaBase;
            while (true) {
                monedaBase = lectura.nextLine();
                try {
                    consulta.setMonedaBase(monedaBase);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            // Solicita la moneda destino y verifica que cumpla con las reglas
            System.out.println("Ingrese la moneda destino para ejecutar la conversión.\n (Ejemplo - código de moneda: EUR)");
            String monedaDestino;
            while (true) {
                monedaDestino = lectura.nextLine();
                try {
                    consulta.setMonedaDestino(monedaDestino);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            // Solicita la cantidad y verifica que sea numérica
            System.out.println("Ingrese la cantidad de moneda base a convertir.\n (Ejemplo - cantidad: 100)");
            while (true) {
                if (lectura.hasNextInt()) {
                    int cantidad = lectura.nextInt();
                    lectura.nextLine();
                    try {
                        consulta.setCantidad(cantidad);
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("Solo se acepta un valor númerico positivo. Intente nuevamente:");
                    lectura.next(); // Descartar el valor no numérico
                }
            }
            // Construcción de la URL para la solicitud HTTP
            String direccion = consulta.getLinkPrincipal() + consulta.getClaveApi() + consulta.getEndpoint() + consulta.getMonedaBase() + "/" + consulta.getMonedaDestino() + "/" + consulta.getCantidad();

            // Configuración y envío de la solicitud HTTP
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccion)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Obtiene el cuerpo de la respuesta HTTP como una cadena JSON y es almacenada en la variable "json".
            String json = response.body();

            // Imprime el contenido JSON de la respuesta HTTP para verificar su formato o depurar el resultado recibido.
            //System.out.println(json);

            System.out.println("----------------------------------------------------------------------------------\n" +
                    "El resultado de la conversión de moneda solicitada, es la siguiente:");

            Gson gson = new Gson(); // Crea una instancia de la clase Gson.


            Monedas monedas = gson.fromJson(json, Monedas.class); // Convierte el JSON almacenado en 'json' a un objeto de la clase 'Monedas' usando Gson.
            Atributos miAtributos = new Atributos(monedas); // Crea una instancia de 'Atributos' usando el objeto 'monedas', que contiene los datos convertidos del JSON.
            System.out.println(miAtributos); // Imprime el objeto 'miAtributos' para verificar los valores de los atributos después de la conversión.

            // Agrega la conversión al historial después de la impresión de miAtributos
            com.qullqi.conversormoneda.historial.HistorialConversiones.agregarConversion(
                    consulta.getMonedaBase(), consulta.getMonedaDestino(),
                    miAtributos.getTasaDeConversion(), miAtributos.getResultadoConversion()
            );

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
