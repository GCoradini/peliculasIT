package com.educacionIT.peliculas.infra.exception;

public class PersonajeNotFoundException extends RuntimeException{
    public PersonajeNotFoundException(String msg) {
        super(msg);
    }
}
