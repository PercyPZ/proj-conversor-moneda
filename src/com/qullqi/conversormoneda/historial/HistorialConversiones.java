package com.qullqi.conversormoneda.historial;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HistorialConversiones {
    private static final String FILE_PATH = "HistorialConversiones.json";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    // Método para agregar una conversión al historial
    public static void agregarConversion(String monedaBase, String monedaDestino, double tasaConversion, double resultado) {
        List<String> historial = obtenerHistorial();
        String fechaHora = LocalDateTime.now().format(DATE_FORMATTER);
        String entrada = "Fecha y hora= " + fechaHora + ", Moneda base= " + monedaBase + ", Moneda destino= " + monedaDestino +
                ",\nTasa de conversión= " + tasaConversion + ", Resultado de conversión= " + resultado;

        historial.add(entrada);
        guardarHistorial(historial);
    }

    // Método para obtener el historial completo
    public static List<String> obtenerHistorial() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<ArrayList<String>>() {}.getType();
            return new Gson().fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    // Método para guardar el historial en el archivo JSON
    private static void guardarHistorial(List<String> historial) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            new Gson().toJson(historial, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar el historial.");
        }
    }
}
