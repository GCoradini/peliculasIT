package com.educacionIT.peliculas.infra.exception;

public class PeliculaNotFoundException extends RuntimeException{
    public PeliculaNotFoundException(String msg) {
        super(msg);
    }
}
