package com.educacionIT.peliculas.controlador.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeneroDtoRequest {
    private String nombre;
}
