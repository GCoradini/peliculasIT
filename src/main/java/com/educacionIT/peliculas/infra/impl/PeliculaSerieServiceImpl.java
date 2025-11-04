package com.educacionIT.peliculas.infra.impl;

import com.educacionIT.peliculas.core.dominio.PeliculaSerie;
import com.educacionIT.peliculas.core.service.PeliculaSerieService;
import com.educacionIT.peliculas.infra.database.entity.PeliculaSerieEntity;
import com.educacionIT.peliculas.infra.database.repository.PeliculaJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PeliculaSerieServiceImpl implements PeliculaSerieService {

    private final PeliculaJPARepository peliculaJPARepository;

    @Override
    public List<PeliculaSerie> findAll() {
        List<PeliculaSerieEntity> peliculaSeries = peliculaJPARepository.findAll();
        return PeliculaSerieEntity.toDomain(peliculaSeries);
    }

    @Override
    public PeliculaSerie findByTitulo(String titulo) {
        PeliculaSerieEntity peliculaSerie = peliculaJPARepository.findByTitulo(titulo);
        return PeliculaSerieEntity.toDomain(peliculaSerie);
    }

    @Override
    public List<PeliculaSerie> findByGenero(String genero) {
        List<PeliculaSerieEntity> peliculaSeries = peliculaJPARepository.findByGenero(genero);
        return PeliculaSerieEntity.toDomain(peliculaSeries);
    }

    @Override
    public List<PeliculaSerie> findByFecha(LocalDate fechaDesde, LocalDate fechaHasta) {
        List<PeliculaSerieEntity> peliculaSeries = peliculaJPARepository.findByFechaCreacionBetween(fechaDesde, fechaHasta);
        return PeliculaSerieEntity.toDomain(peliculaSeries);
    }

    @Override
    public List<PeliculaSerie> findByCalificacion(Byte desde, Byte hasta) {
        List<PeliculaSerieEntity> peliculaSeries =
                peliculaJPARepository.findByCalificacionGreaterThanEqualAndCalificacionLessThanEqual(desde, hasta);
        return PeliculaSerieEntity.toDomain(peliculaSeries);
    }

    @Override
    public PeliculaSerie save(PeliculaSerie peliculaSerie) {
        peliculaJPARepository.save(PeliculaSerieEntity.toEntity(peliculaSerie));
        return peliculaSerie;
    }
}
