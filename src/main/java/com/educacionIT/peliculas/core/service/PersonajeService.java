package com.educacionIT.peliculas.core.service;

import com.educacionIT.peliculas.core.dominio.Personaje;
import java.util.List;

public interface PersonajeService {

    List<Personaje> findAll();

    Personaje findByName(String nombre);

    List<Personaje> findByAge(Integer edad);

    List<Personaje> findBetweenAge(Integer edadDesde, Integer edadHasta);

}
