# Conversor de Monedas - Challenge Java

## Descripción del Proyecto
Este proyecto es una aplicación de consola desarrollada en Java que permite a los usuarios convertir valores entre diferentes monedas en tiempo real. La aplicación se conecta a la API de ExchangeRate para obtener las tasas de cambio actualizadas, procesa los datos en formato JSON y realiza los cálculos matemáticos correspondientes.

## Funcionalidades
* Menú interactivo en la consola para elegir entre 6 opciones de conversión de monedas.
* Filtrado de monedas específicas (Ej: USD, ARS, BRL, COP).
* Consumo de una API REST (ExchangeRate-API) para obtener tasas de conversión precisas.
* Análisis y extracción de datos JSON.
* Manejo de errores de conexión y entradas de usuario.

## Tecnologías Utilizadas
* **Java 17+** (Uso de `HttpClient`, `HttpRequest`, `HttpResponse`)
* **Gson** (Para la serialización y deserialización de objetos JSON)
* **ExchangeRate-API** (Fuente de datos)
* **IntelliJ IDEA** (Entorno de desarrollo)

## Cómo ejecutar el proyecto
1. Clona este repositorio en tu máquina local.
2. Abre el proyecto en tu IDE (recomendado: IntelliJ IDEA).
3. Asegúrate de tener la biblioteca **Gson** agregada al *classpath* del proyecto.
4. Obtén una API Key gratuita en [ExchangeRate-API](https://www.exchangerate-api.com/) y reemplázala en el código fuente (clase `Conversor`).
5. Ejecuta la clase `ConversorApp` para iniciar el menú en la consola.

## Autor
[Carlos Eduardo Barra Cconcho / C4R127]
