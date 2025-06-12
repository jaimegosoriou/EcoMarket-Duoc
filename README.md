# EcoMarket - Microservicios de Compras e Inventario

Este proyecto corresponde a una solución de arquitectura de microservicios desarrollada para la evaluación de la asignatura DSY1104 - Desarrollo Fullstack I.

##  Estructura del Proyecto

- **microservice-compra**: Servicio de gestión de compras.
- **microservice-inventario** (por agregar): Servicio de gestión de inventario.
- **microservice-config**: Servicio de configuración general del sistema.
- **microservice-gatwaty**: Servicio de congiguracion de apis.
- **microservice-eureja**: Servicio de monitore de microservicios.

##  Tecnologías Utilizadas

- Java 17
- Spring Boot
- Spring Web, Data JPA
- Maven
- MySQL
- Git
- Postman

##  Configuración del Entorno

1. **Base de Datos**: Configurada en `application.properties`.
2. **Compilación**: Utilizar Maven (`mvn clean install`).
3. **Ejecución**: Ejecutar `CompraApplication.java` desde Spring Boot.

## Funcionalidades Implementadas

- CRUD para compras.
- Repositorio JPA para persistencia de datos.
- API REST en `CompraController`.

## Pruebas

- Producto (Inventario)
  GET http://localhost:8081/productos

  POST http://localhost:8081/productos
   Body JSON:

    {
        "nombre": "Compostera",
        "precio": 19990,
        "cantidad": 50
    }
DELETE http://localhost:8081/productos/1

- Compra
  GET http://localhost:8082/compras

  POST http://localhost:8082/compras
    Body JSON:

    {
        "fecha": "2025-06-07",
        "total": 39990
    }

DELETE http://localhost:8082/compras/1


## Trabajo Colaborativo

El código fue gestionado con Git para el control de versiones, siguiendo buenas prácticas de modularidad y mantenimiento de los servicios.


