package com.educacionIT.peliculas.core.dominio;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Genero {
    private Long id;
    private String nombre;
    private List<PeliculaSerie> peliculaSerie;

}
