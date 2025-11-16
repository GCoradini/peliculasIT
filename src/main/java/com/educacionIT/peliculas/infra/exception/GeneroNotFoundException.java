package com.educacionIT.peliculas.infra.exception;

public class GeneroNotFoundException extends RuntimeException{
    public GeneroNotFoundException(String msg) {
        super(msg);
    }
}
