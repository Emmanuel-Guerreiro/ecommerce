# Proyecto integrador Taller de Programacion avanzada

Ecommerce a modo de trabajo integrador para la materia taller de programacion avanzada

## Definir tematica del Market Place

El ecommerce ofrecera ropa informal, y sera orientado a adolescentes y jovenes.

## Integrantes del grupo:

    - Santiago Ruiz Cucchiarelli
    - Zacarías Garcia
    - Marcio Palazzo
    - Emmanuel Guerreiro

## Buscar inspiración en referentes del mercado

Los siguientes ecommerce's son interesantes porque apuntan a un mismo grupo de clientes, y los servicios son similares

Tambien tienen un conjunto de funcionalidades interesantes para imitar

[Cristobal Colon](https://www.cristobalcolon.com/)  
[Rusty](https://rusty.com.au/)  
[Billabong](https://www.billabong.cl/)  
[Moov](https://www.moov.com.ar/)  
[DigitalSport](https://www.digitalsport.com.ar/)

## Como correr el sistema

### Requerimientos

- Java 11
- maven
- Docker + Docker compose -opcional-

### Pasos a seguir

Esta disponible un `docker-compose.yml` que provee la posibilidad de levantar una instancia de MySQL

Para poder levantar el contenedor

```
sudo docker-compose up --build
```

Una vez corriendo la instancia de MySQL correr la aplicacion

Si no se tiene un IDE que provea la funcionalidad correr en la terminal

```
mvn spring-boot:run
```

## Postman

Se han realizado un conjunto de pruebas con Postman

Las pruebas estan dentro del directorio [`/postman/`](/postman/)

Para poder utilizarlas dentro de una instancia propia de postman, leer la [documentacion dentro del directorio](/postman/README.md)

## Notas finales

Respecto a los endpoints, algunos tienen algunos problemas a solucionar (especificamente los de agregar item a un carrito, o pagar un carrito)

Estos seran solucionados mas facilmente cuando se pueda implementar los DTOS
