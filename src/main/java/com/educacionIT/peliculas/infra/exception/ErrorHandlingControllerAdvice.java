package com.educacionIT.peliculas.infra.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.Collections;

@ControllerAdvice
@Slf4j
public class ErrorHandlingControllerAdvice {

    public static final String DESCRIPCION_ERROR_NO_ENCONTRADO = "El recurso solicitado no fue encontrado";

    @ExceptionHandler({PersonajeNotFoundException.class, PeliculaNotFoundException.class, GeneroNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleNotFoundException(RuntimeException e) {
        log.error("Error: {}", e.getMessage());
        return new ErrorResponse(DESCRIPCION_ERROR_NO_ENCONTRADO,
                Collections.singletonList(new ErrorGenerico(e.getMessage())));
    }
}
