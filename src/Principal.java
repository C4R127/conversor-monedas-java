import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Principal {
    public static void main(String[] args) {
        // 1. Armamos la URL (¡Pon tu clave aquí!)
        // Ejemplo pidiendo la conversión de Dólar (USD) a Sol Peruano (PEN)
        String direccion = "https://v6.exchangerate-api.com/v6/TU_API_KEY/pair/USD/PEN";
        try {
            // 2. Creamos el "Cliente" que hará la conexión
            HttpClient client = HttpClient.newHttpClient();

            // 3. Creamos la "Solicitud" (Request) a la URL
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            // 4. Enviamos la solicitud y guardamos la "Respuesta" (Response)
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 5. Imprimimos el cuerpo de la respuesta (Debería ser el mismo JSON que viste en el navegador)
            System.out.println(response.body());

        } catch (Exception e) {
            System.out.println("Ocurrió un error al conectar con la API: " + e.getMessage());
        }
    }
}