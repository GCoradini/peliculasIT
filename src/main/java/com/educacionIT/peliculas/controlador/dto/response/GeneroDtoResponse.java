package com.educacionIT.peliculas.controlador.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GeneroDtoResponse {
    private String nombre;
    private List<PeliculaDtoResponse> peliculaSerie;
}
