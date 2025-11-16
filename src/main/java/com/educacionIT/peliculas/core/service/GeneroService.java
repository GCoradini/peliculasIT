package com.educacionIT.peliculas.core.service;

import com.educacionIT.peliculas.core.dominio.Genero;
import java.util.List;

public interface GeneroService {

    List<Genero> findAll();

    Genero findById(Long id);

    Genero save(Genero genero);
}
