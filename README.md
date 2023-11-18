# Proyecto API REST con Spring Boot

API REST desarrollada con Spring Boot 3.1.5 y utiliza JPA para la interacción con una base de datos MySQL, haciendo uso de Spring Data. Para mejorar la documentación de los endpoints, se integró y configuró Swagger 3. Además, se implementó MapStruct para facilitar la conversión entre clases, permitiendo así no exponer la estructura interna de la base de datos.
La arquitectura del proyecto sigue una estructura por capas, lo que contribuye a una organización clara y mantenible del código. Esta organización por capas facilita la separación de responsabilidades y mejora la escalabilidad del sistema. En conjunto, estas tecnologías y prácticas se combinan para crear una API REST eficiente, bien documentada y fácilmente mantenible.

## Tecnologías Utilizadas

- **Spring Boot 3.1.5**
- **Java 17**
- **JPA**
- **MySQL**
- **MapStruct**
- **Swagger**
  
## Características Principales
- **Operaciones Create, Reade, Delete para la entidad "Product" y "Purchase"**
- **Uso de MapStruct para el mapeo y conversión**
- **Documentación generada automáticamente con Swagger**

## Ejemplos de Uso de las Operaciones

- **Guardar nuevo producto**
  ```xml
  POST /product/save
  {
    "productId": 0,
    "name": "string",
    "categoryId": 0,
    "price": 0,
    "stock": 0,
    "active": true,
    "category": {
      "categoryId": 0,
      "category": "string",
      "active": true
    }
  }
  ```
- **Obtener producto por id**
  ```xml
  GET /producs/{id}
  ```
- **Obtener productos por id de categoria**
  ```xml
  GET /producs/category/{categoryId}
  ```
- **Obtener productos**
  ```xml
  GET /producs/all
  ```
- **Borrar producto**
  ```xml
  DELETE /producs/delete/{id}
  ```
- **Guardar compra**
  ```xml
  POST /pruchase/save
  ```
- **Obtener compra por id del cliente**
  ```xml
  GET /pruchase/cliente/{idClient}
  ```
- **Obtener compras**
  ```xml
  GET /pruchase/all
  ```

## Documentación Swagger

Accede a la interfaz Swagger en http://localhost:8080/swagger-ui/index.html#/. Esta interfaz te proporciona documentación interactiva sobre la API, permitiéndote probar las solicitudes directamente desde el navegador. El archivo de configuración de Swagger esta en la ruta web/config/SwaggerConf
![image](https://github.com/FranKR02/API-Market/assets/62808108/bf02d3da-3e53-471c-b367-fa04669c27b7)

## Dependencias
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct</artifactId>
        <version>1.5.5.Final</version>
    </dependency>
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.2.0</version>
    </dependency>
</dependencies>
```
