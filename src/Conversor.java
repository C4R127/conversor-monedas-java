import java.util.Scanner;

public class Conversor {

    // Método principal del menú
    public static void eleccionUserMenu() {
        Scanner lectura = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 7) {
            System.out.println("*******************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
            System.out.println("1) Dólar (USD) => Peso argentino (ARS)");
            System.out.println("2) Peso argentino (ARS) => Dólar (USD)");
            System.out.println("3) Dólar (USD) => Real brasileño (BRL)");
            System.out.println("4) Real brasileño (BRL) => Dólar (USD)");
            System.out.println("5) Dólar (USD) => Peso colombiano (COP)");
            System.out.println("6) Peso colombiano (COP) => Dólar (USD)");
            System.out.println("7) Salir");
            System.out.println("Elija una opción válida:");
            System.out.println("*******************************************");

            opcion = lectura.nextInt();

            switch (opcion) {
                case 1:
                    realizarConversion("USD", "ARS", lectura);
                    break;
                case 2:
                    realizarConversion("ARS", "USD", lectura);
                    break;
                case 3:
                    realizarConversion("USD", "BRL", lectura);
                    break;
                case 4:
                    realizarConversion("BRL", "USD", lectura);
                    break;
                case 5:
                    realizarConversion("USD", "COP", lectura);
                    break;
                case 6:
                    realizarConversion("COP", "USD", lectura);
                    break;
                case 7:
                    System.out.println("Saliendo del programa, ¡gracias por usar el conversor!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    // Método específico para el cálculo (como sugiere el tip de la plataforma)
    public static void realizarConversion(String monedaBase, String monedaObjetivo, Scanner lectura) {
        System.out.println("Ingrese el valor que deseas convertir:");
        double cantidad = lectura.nextDouble();

        // Armamos la URL con las monedas elegidas
        // ¡OJO! Asegúrate de poner tu API_KEY real aquí
        String urlFinal = "https://v6.exchangerate-api.com/v6/TU_API_KEY_AQUI/pair/" + monedaBase + "/" + monedaObjetivo;
        try {
            // Llamamos al método que hicimos en ConversorApp para traer la tasa
            double tasaDeConversion = ConversorApp.obtenerTasa(urlFinal);

            // Lógica de conversión: Multiplicamos la cantidad por la tasa
            double resultadoFinal = cantidad * tasaDeConversion;

            // Mostramos el resultado final
            System.out.println("El valor " + cantidad + " [" + monedaBase + "] corresponde al valor final de =>>> " + resultadoFinal + " [" + monedaObjetivo + "]");
            System.out.println("\n");

        } catch (Exception e) {
            System.out.println("Ocurrió un error en la conversión.");
        }
    }
}