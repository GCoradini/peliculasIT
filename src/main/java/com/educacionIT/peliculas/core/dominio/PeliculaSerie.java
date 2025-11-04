package com.educacionIT.peliculas.core.dominio;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PeliculaSerie {

    private Long id;
    private String titulo;
    private LocalDate fechaCreacion;
    private Byte calificacion;
    private List<Personaje> personajesAsociados;

}
