package com.educacionIT.peliculas.controlador.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class PeliculaDtoResponse {
    private Long id;
    private String titulo;
    private LocalDate fechaCreacion;
    private Byte calificacion;
    private List<PersonajeDtoResponse> personajesAsociados;
}
