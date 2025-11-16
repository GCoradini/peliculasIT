package com.educacionIT.peliculas.infra.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorGenerico {

    private final String mensajeError;

}
