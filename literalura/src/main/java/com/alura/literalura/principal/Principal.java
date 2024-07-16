package com.alura.literalura.principal;

import com.alura.literalura.model.Autor;
import com.alura.literalura.model.DatosRespuesta;
import com.alura.literalura.model.DatosLibro;
import com.alura.literalura.model.DatosAutor;
import com.alura.literalura.model.Libro;
import com.alura.literalura.repository.AutorRepository;
import com.alura.literalura.repository.LibroRepository;
import com.alura.literalura.service.ConsumoAPI;
import com.alura.literalura.service.ConvierteDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal implements com.alura.literalura.principal.menu {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private ConvierteDatos conversor =  new ConvierteDatos();

    private LibroRepository libroRepository;
    private AutorRepository autorRepository;

    public Principal(LibroRepository libroRepository, AutorRepository autorRepository){
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public void muestraElMenu() {
        System.out.println(bienvenida);
        var opcion = 0;
        while (opcion != 9) {

            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibro();
                    break;
                case 2:
                    mostrarLibrosRegistrados();
                    break;
                case 3:
                    listaDeAutoresRegistrados();
                    break;
                case 4:
                    listaAutoresVivosEnUnAnio();
                    break;
                case 5:
                    listaDeLibrosPorIdioma();
                    break;
                case 6:
                    top10LibrosMasDescargados();
                    break;

                case 9:
                    System.out.println(cerrandoApp);
                    break;
                default:
                    System.out.println(libroNoEncontrado);
            }
        }

    }


    private DatosRespuesta getDatosLibro(){
        System.out.println(busquedaLibro);
        var nombreLibro = teclado.nextLine();
        var json = consumoAPI.obtenerDatos(URL_BASE + nombreLibro.replace(" ", "%20"));
        System.out.println(json);
        DatosRespuesta datos = conversor.obtenerDatos(json, DatosRespuesta.class);
        return datos;
    }

    private void buscarLibro() {
        DatosRespuesta datos = getDatosLibro();

        if(!datos.results().isEmpty()){
            Libro libro = new Libro(datos.results().get(0));
            libro = libroRepository.save(libro);
        }
        System.out.println("Datos: ");
        System.out.println(datos);
    }

    private void mostrarLibrosRegistrados() {
        List<Libro> libros = libroRepository.findAll();

        if (!libros.isEmpty()){
            for (Libro libro : libros) {
                System.out.println("\n\n★★★★★★★★ LIBROS ★★★★★★★★\n");
                System.out.println(" Titulo: " + libro.getTitulo());
                System.out.println(" Autor: " + libro.getAutor().getNombre());
                System.out.println(" Idioma: " + libro.getIdioma());
                System.out.println(" Descargas: " + libro.getDescargas());
                System.out.println("\n ★★★★★★★★★★★★★★★★★★★★★★\n\n");
            }

        } else {
            System.out.println(resultadoNoEncontrado);
        }

    }

    private void listaDeAutoresRegistrados() {
        List<Autor> autores = autorRepository.findAll();

        if (!autores.isEmpty()){
            for (Autor autor : autores){
                System.out.println("\n\n★★★★★★★★ Autores ★★★★★★★★\n");
                System.out.println(" Nombre: " + autor.getNombre());
                System.out.println(" Fecha de Nacimiento: " + autor.getFechaNacimiento());
                System.out.println(" Fecha de Fallecimiento: " + autor.getFechaDeceso());
                System.out.println(" Libros: " + autor.getLibro().getTitulo());
                System.out.println("\n ★★★★★★★★★★★★★★★★★★★★★★\n\n");
            }
        }else {
            System.out.println(resultadoNoEncontrado);
            }
    }

    private void listaAutoresVivosEnUnAnio() {
        System.out.println("Escriba el año que desea consultar:");
        var anio = teclado.nextInt();
        teclado.nextLine();

        List<Autor> autores = autorRepository.encontrarPorAnio(anio);

        if (!autores.isEmpty()){
            for (Autor autor : autores) {
                System.out.println("\n\n★★★★★★★ Autores Vivos ★★★★★★★\n");
                System.out.println(" Nombre: " + autor.getNombre());
                System.out.println(" Fecha de nacimiento: " + autor.getFechaNacimiento());
                System.out.println(" Fecha de fallecimiento: " + autor.getFechaDeceso());
                System.out.println(" Libros: " + autor.getLibro().getTitulo());
                System.out.println("\n ★★★★★★★★★★★★★★★★★★★★★★\n\n");
        }} else {
                System.out.println(resultadoNoEncontrado);
            }
    }

    private void listaDeLibrosPorIdioma() {
        System.out.println(librosIdiomas);
        var idioma = teclado.nextInt();
        String idiomaSeleccionado = " ";

        switch (idioma){
            case 1:
                idiomaSeleccionado = "es";
                break;
            case 2:
                idiomaSeleccionado = "en";
                break;
            case 3:
                idiomaSeleccionado = "fr";
                break;
            default:
                System.out.println(resultadoNoEncontrado);
                break;
        }
        List<Libro> libros = libroRepository.encontrarPorIdioma(idiomaSeleccionado);

        if (!libros.isEmpty()) {

            for (Libro libro : libros) {
                System.out.println("\n\n★★★★★★★ LIBROS POR IDIOMA ★★★★★★★\n");
                System.out.println(" Titulo: " + libro.getTitulo());
                System.out.println(" Autor: " + libro.getAutor().getNombre());
                System.out.println(" Idioma: " + libro.getIdioma());
                System.out.println(" Descargas: " + libro.getDescargas());
                System.out.println("\n ★★★★★★★★★★★★★★★★★★★★★★\n\n");
            }

        } else {
            System.out.println(resultadoNoEncontrado);
        }

    }

    private void top10LibrosMasDescargados() {
        List<Libro> topLibros = libroRepository.findTop10ByOrderByDescargasDesc();
        topLibros.forEach(s ->
                System.out.println("Libro: " + s.getTitulo() + " Descargas: " + s.getDescargas()));
    }
}
