package com.educacionIT.peliculas.core.dominio;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Personaje {

    private Long id;
    private String nombre;
    private Integer edad;
    private Double peso;
    private String historia;
    private PeliculaSerie peliculaSerie;

}
