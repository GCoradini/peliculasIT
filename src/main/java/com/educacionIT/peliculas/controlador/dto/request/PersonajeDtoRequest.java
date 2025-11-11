package com.educacionIT.peliculas.controlador.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonajeDtoRequest {
    private String nombre;
    private Integer edad;
    private Double peso;
    private String historia;
}
