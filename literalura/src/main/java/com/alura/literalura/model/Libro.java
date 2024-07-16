package com.alura.literalura.model;
import com.alura.literalura.config.CadenaConfig;
import com.alura.literalura.model.Autor;
import com.alura.literalura.model.Libro;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String titulo;
    private String idioma;
    private Integer descargas;
    @OneToOne(mappedBy = "libros", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Autor autor;

    public Libro(){}

    public Libro(DatosLibro datosLibro){
        this.titulo = CadenaConfig.limitarLong(datosLibro.titulo(), 200);
        this.descargas = datosLibro.descargas();
        if (!datosLibro.idioma().isEmpty())
            this.idioma = datosLibro.idioma().get(0);
        if (!datosLibro.autor().isEmpty()) {
            for (DatosAutor datosAutor : datosLibro.autor()) {
                this.autor = new Autor(datosAutor);
                break;
            }
        }
    }

    @Override
    public String toString(){
        return "titulo= " + titulo + '\'' +
                "autor= " + autor + '\'' +
                "idioma= " + idioma + '\'' +
                "descargas= " + descargas + '\'';
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getDescargas() {
        return descargas;
    }

    public void setDescargas(Integer descargas) {
        this.descargas = descargas;
    }
}
