INDICE
  Descripción del Proyecto
  Estado del Proyecto
  Demostración de Funciones y Aplicaciones
  Acceso al Proyecto
  Tecnologías utilizadas
  Personas Contribuyentes
  Persona Desarrolladora del Proyecto


Descripción del Proyecto:
  
  - Qullqi, es un conversor de monedas desarrollado en Java que permite realizar conversiones de una moneda a otra en tiempo real, consultando los valores de cambio mediante la "API ExchangeRate-API". Ofrece además un historial de conversiones que guarda la fecha y los detalles de cada transacción en un archivo `.json` para fácil acceso.
  
  - El proyecto incluye una lista de monedas admitidas y valida las entradas para garantizar que los códigos de moneda sean correctos y que la cantidad sea válida antes de realizar una conversión.


Estado del Proyecto:

  - Este proyecto se encuentra en su primera versión funcional y estable (v1.0). Se han implementado todas las funciones principales descritas, y el historial de conversiones se guarda en un archivo local para referencia futura.


Demostración de Funciones y Aplicaciones:

  Conversión de Monedas: 
   - El usuario ingresa un código de moneda de origen, un código de moneda de destino y la cantidad a convertir.
   - La clase `ConsultaApi` realiza la solicitud HTTP y obtiene la tasa de conversión de la API para calcular el valor final.
  
  Historial de Conversiones:
   - Cada conversión se guarda con la fecha y hora, moneda de origen, moneda de destino, tasa de conversión y el resultado.
   - Este historial se almacena en un archivo JSON (`HistorialConversiones.json`), permitiendo su consulta posterior mediante la clase `HistorialConversiones`.

  Lista de Monedas Admitidas:
   - La clase `ListaMoneda` muestra las monedas aceptadas, facilitando al usuario la selección de las monedas válidas para su conversión.


Acceso al Proyecto:

  Descarga el proyecto del siguiente link:


Tecnologías utilizadas:

  Java: Lenguaje de programación principal.
  ExchangeRate-API: API utilizada para obtener las tasas de cambio de divisas en tiempo real.
  Gson: Biblioteca para la manipulación y serialización de JSON en Java.
  Maven: Herramienta de gestión de dependencias y construcción.
  

Personas Contribuyentes:

  Instructores de Alura Latam: Génesys Rondón, Bruno Dario Férnandez Ellerbach y Eric Monné Fraga de Oliveira (tutoría)
  

Persona Desarrolladora del Proyecto:

  Percy Ponce Zegarra - desarrollador y creador de la lógica de conversión.



  


  
