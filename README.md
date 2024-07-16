# ProyectoLiteralura

*[Índice](#índice)
* [Descripción del proyecto](#descripción-del-proyecto)
* [Estado del proyecto](#estado-del-proyecto)
* [Acceso al proyecto](#acceso-al-proyecto)
* [Tecnologías utilizadas](#tecnologías-utilizadas)
* [Desarrollador del Proyecto](#desarrollador-del-proyecto)
* [Conclusión](#conclusión)

## Descripción del proyecto

Desarrollo de una aplicación para la gestión de libros y autores utilizando Spring Boot, Hibernate, y PostgreSQL. La aplicación permite buscar libros por título, listar libros y autores registrados, encontrar autores vivos en un determinado año, listar libros por idioma, y mostrar los top 10 libros. Se utilizó el IDE de IntelliJ IDEA para programar la aplicación en JAVA 17.

## Descripción de funcionamiento

Al correr la aplicación, se inicia con un menú que presenta varias opciones:

- Buscar libro por título.
- Lista de libros registrados.
- Lista de autores registrados.
- Lista de autores vivos en un determinado año.
- Lista de libros por idioma.
- Top 10 libros.
- Salir de la aplicación.

### Buscar libro por título

Permite buscar un libro específico por su título.

### Lista de libros registrados

Muestra una lista de todos los libros que están registrados en la base de datos.

### Lista de autores registrados

Muestra una lista de todos los autores registrados en la base de datos.

### Lista de autores vivos en un determinado año

Permite ingresar un año y muestra una lista de autores que estaban vivos en ese año.

### Lista de libros por idioma

Permite listar los libros filtrados por un idioma específico.

### Top 10 libros

Muestra una lista de los 10 libros más populares.

### Salir

Finaliza la aplicación.

## Estado del proyecto

![Badge en Desarollo](https://img.shields.io/badge/STATUS-%20FINALIZADO-orange)

## Acceso al proyecto

Para ejecutar el proyecto, clona el repositorio y configura tu base de datos PostgreSQL con los detalles proporcionados en el archivo `application.properties`. Luego, puedes compilar y ejecutar la aplicación desde la clase principal localizada en `src/main/java/com/proyectoliteratura/ProyectoLiteraturaApplication.java`.

## Tecnologías utilizadas

- JAVA 17
- Spring Boot
- PostgreSQL
- IntelliJ IDEA
- Hibernate

## Desarrollador del Proyecto

Jorge A. Rivero Fragoso

## Conclusión

Este proyecto de consulta de bibliografía proporciona una herramienta sencilla y eficiente para manejar información sobre libros y autores, utilizando tecnologías modernas como Spring Boot y Hibernate. Además, se integró la funcionalidad de consulta dinámica y gestión de datos a través de una base de datos PostgreSQL.

