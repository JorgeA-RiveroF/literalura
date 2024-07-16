package com.alura.literalura.principal;

public interface menu {

    //Mensaje de bienvenida (Inicio de aplicación)
    String bienvenida = """ 
                                *** Bienvenido/a al Challenge 'Literalura' *** 
                                *** by J. A. Rivero Fragoso ***
                            """;
    //Impresion main menu
    String menu = """
                ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
                *** Escriba el número de la opción que quiera realizar ***
                1 - Buscar libro por título
                2 - Lista de libros registrados
                3 - Lista de Autores registrados
                4 - Lista de autores vivos en un determinado año
                5 - Lista de libros por idioma
                6 - Top 10 libros
                
                9 - Salir
                ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
                """;

    //Libro no encontrado
    String libroNoEncontrado = """
            ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
            Libro no entrado, favor de verificar el título.
            ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
            """;
    //menu libros por idioma
    String librosIdiomas = """
            ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
            Seleccione un Idioma:
            1.- Español
            2.- Ingles         
            3.- Frances   
            ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
            """;

    //mensaje despedida
    String cerrandoApp = """
            ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
            Cerrando la aplicación...
              """;

    //Libro no encontrado
    String resultadoNoEncontrado = """
            ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
            Resultado no entrado, favor de verificar el título.
            ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
            """;

    //busqueda por libro
    String busquedaLibro = """
            ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
            Escribe el nombre del libro que quieres buscar: 
            """;


}
