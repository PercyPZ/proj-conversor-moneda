package com.qullqi.conversormoneda.mensaje;

public class Mensajes {


    public static void mensaje1 () {
        String mensajeDeBienvenida = """
                ----------------------------------------------------------------------------------
                ¡Bienvenido(a) a Qullqi, tu aliado para convertir monedas al instante!""";

        System.out.println(mensajeDeBienvenida);
    }

    public static void mensaje2 () {

        String menuDeOpciones = """
                ----------------------------------------------------------------------------------
                *** Escriba el número de la opción deseada ***
                1. Lista de monedas admitidas por el aplicativo
                2. Realizar una conversión de monedas
                3. Consultar historial de conversiones
                4. Salir
                ----------------------------------------------------------------------------------
                """;

        System.out.println(menuDeOpciones);
    }

    public static void mensaje3 () {
        System.out.println("----------------------------------------------------------------------------------\n" +
                "Gracias por utilizar nuestra aplicación."   );
    }
}
