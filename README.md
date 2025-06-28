# Sistema de Pedidos para Restaurante

## Descripción

Este proyecto es una aplicación Java que simula un sistema de pedidos para un restaurante. Permite a los usuarios seleccionar diferentes tipos de sándwiches y añadir "adicionales" como bebidas, postres, sopas e ingredientes extra, aplicando el patrón de diseño Decorator para una gestión flexible de los complementos. La aplicación cuenta con una interfaz gráfica de usuario (GUI) para facilitar la interacción.

## Características

*   **Selección de Sándwiches:** Elige entre Sándwich de Res, Pavo o Pollo.
*   **Adicionales Personalizables:** Añade complementos a tu sándwich como:
    *   Refresco
    *   Postre
    *   Sopa
    *   Aguacate
    *   Hongos
    *   Doble Proteína
*   **Cálculo Automático de Precios:** El sistema calcula el precio total del pedido basándose en el sándwich base y los adicionales seleccionados.
*   **Interfaz Gráfica de Usuario (GUI):** Interfaz intuitiva para realizar y visualizar pedidos.

## Requisitos

*   Java Development Kit (JDK) 8 o superior.
*   Apache Maven (para la gestión de dependencias y construcción del proyecto).

## Instalación

1.  **Clonar el Repositorio:**
    ```bash
    git clone <URL_DEL_REPOSITORIO>
    cd <NOMBRE_DEL_REPOSITORIO>
    ```
2.  **Construir el Proyecto con Maven:**
    ```bash
    mvn clean install
    ```

## Uso

Para ejecutar la aplicación y utilizar la interfaz gráfica:

1.  **Compilar y Ejecutar:**
    ```bash
    mvn spring-boot:run
    ```
    Esto iniciará la aplicación y la GUI del restaurante debería aparecer en una nueva ventana.

## Estructura del Proyecto

*   `src/main/java/com/example/demo/`: Contiene el código fuente principal de la aplicación.
    *   `Sandwich.java`: Interfaz base para los sándwiches.
    *   `SandwichBeef.java`, `SandwichPavo.java`, `SandwichPollo.java`: Implementaciones concretas de sándwiches.
    *   `AdicionalDecorator.java`: Clase abstracta para los decoradores.
    *   `Refresco.java`, `Postre.java`, `Sopa.java`, `Aguacate.java`, `Hongos.java`, `DobleProteina.java`: Clases concretas de decoradores (adicionales).
    *   `Orden.java`: Clase para gestionar los detalles de una orden.
    *   `RestauranteGUI.java`: Clase principal que maneja la interfaz gráfica de usuario.
    *   `DemoApplication.java`: Clase principal de la aplicación Spring Boot.
*   `src/main/resources/`: Contiene recursos de la aplicación, como `application.properties`.
*   `src/test/java/com/example/demo/`: Contiene los tests unitarios.

## Patrones de Diseño

Este proyecto hace uso extensivo del **Patrón Decorator** para permitir la adición dinámica de responsabilidades (adicionales) a los objetos de sándwich. Esto promueve la flexibilidad y la extensibilidad del sistema sin modificar las clases base.
