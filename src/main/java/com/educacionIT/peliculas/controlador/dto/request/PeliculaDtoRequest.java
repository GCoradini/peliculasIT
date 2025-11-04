package com.educacionIT.peliculas.controlador.dto.request;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PeliculaDtoRequest {
    private String titulo;
    private LocalDate fechaCreacion;
    private Byte calificacion;
}
