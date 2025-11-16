package com.educacionIT.peliculas.infra.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ErrorResponse {

    private final String descripcion;
    private final List<ErrorGenerico> errores;

}
