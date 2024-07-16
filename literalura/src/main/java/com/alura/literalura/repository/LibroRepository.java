package com.alura.literalura.repository;

import com.alura.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro,Long> {

    List<Libro> findTop10ByOrderByDescargasDesc();

    @Query("SELECT l FROM Libro l WHERE l. idioma >= :idioma")
    List<Libro> encontrarPorIdioma(String idioma);
}
