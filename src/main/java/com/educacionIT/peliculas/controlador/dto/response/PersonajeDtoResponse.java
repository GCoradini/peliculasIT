package com.educacionIT.peliculas.controlador.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonajeDtoResponse {
    private String nombre;
    private Integer edad;
    private Double peso;
    private String historia;
}
