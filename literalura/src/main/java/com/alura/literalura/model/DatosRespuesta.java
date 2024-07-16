package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosRespuesta(@JsonAlias("count") Integer cantidad,
                             @JsonAlias("next") String siguiente,
                             @JsonAlias("previous") String previo,
                             @JsonAlias("results")List<DatosLibro> results
) {
}
