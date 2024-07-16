package com.alura.literalura.model;

import com.alura.literalura.config.CadenaConfig;
import jakarta.persistence.*;

@Entity
@Table(name = "Autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nombre;
    private Integer fechaNacimiento;
    private Integer fechaDeceso;

    @OneToOne
    @JoinTable(name = "Libro",
            joinColumns = @JoinColumn (name = "autor_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))

    private Libro libros;
    public Autor() {
    }

    public Autor(DatosAutor datosAutor) {
        this.nombre = CadenaConfig.limitarLong(datosAutor.nombre(), 200);
        if (datosAutor.fechaNacimiento() == null) {
            this.fechaNacimiento = 404;
        } else {
            this.fechaNacimiento = datosAutor.fechaNacimiento();
        }

        if (datosAutor.fechaDeceso() == null){
            this.fechaDeceso = 404;
        }else {
            this.fechaDeceso = datosAutor.fechaDeceso();
        }
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Integer fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getFechaDeceso() {
        return fechaDeceso;
    }

    public void setFechaDeceso(Integer fechaDeceso) {
        this.fechaDeceso = fechaDeceso;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "Id=" + Id +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", fechaDeceso=" + fechaDeceso +
                '}';
    }

    public Libro getLibro() {
        return libros;
    }

    public void setLibro(Libro libro) {
        this.libros = libros;
    }
}
