import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse; // <-- ¡Nuevo import agregado!

public class ConversorApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        Conversor.eleccionUserMenu();
    }

    public static double obtenerTasa(String urlFinal) throws IOException, InterruptedException {

        // Creando cliente HTTP
        HttpClient cliente = HttpClient.newHttpClient();

        // Creando la solicitud
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(urlFinal))
                .GET()
                .build();

        // --- AQUÍ VA EL NUEVO CÓDIGO DEL PASO 6 ---
        try {
            // Enviando solicitud y recibiendo respuesta
            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

            // ¡Al fin "respuesta" existe! Ahora la conversión a JSON ya no marcará error
            JsonElement elemento = JsonParser.parseString(respuesta.body());
            JsonObject objectRoot = elemento.getAsJsonObject();

            // Accediendo a JsonObject
            double tasa = objectRoot.get("conversion_rate").getAsDouble();
            return tasa;

        } catch (Exception e) {
            // Esto se ejecuta si algo sale mal con la conexión
            System.out.println("Error al conectar con la API: " + e.getMessage());
            return 0; // Retornamos 0 temporalmente si hay un error
        }
        // ------------------------------------------
    }
}