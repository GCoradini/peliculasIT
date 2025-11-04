package com.educacionIT.peliculas.core.service;


import com.educacionIT.peliculas.core.dominio.PeliculaSerie;

import java.time.LocalDate;
import java.util.List;

public interface PeliculaSerieService {

    List<PeliculaSerie> findAll();

    PeliculaSerie findByTitulo(String titulo);

    List<PeliculaSerie> findByGenero(String genero);

    List<PeliculaSerie> findByFecha(LocalDate fechaDesde, LocalDate fechaHasta);

    List<PeliculaSerie> findByCalificacion(Byte desde, Byte hasta);

    PeliculaSerie save(PeliculaSerie peliculaSerie);

}
