package com.educacionIT.peliculas.core.dominio;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Genero {

    private String nombre;
    private List<PeliculaSerie> peliculaSerie;

}
