package com.educacionIT.peliculas.infra.database.repository;

import com.educacionIT.peliculas.infra.database.entity.PeliculaSerieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PeliculaJPARepository extends JpaRepository<PeliculaSerieEntity, Long> {

    PeliculaSerieEntity findByTitulo(String titulo);

    @Query("SELECT p FROM PeliculaSerieEntity p JOIN p.generos g WHERE g.nombre = :genero")
    List<PeliculaSerieEntity> findByGenero(@Param("genero") String genero);

    List<PeliculaSerieEntity> findByFechaCreacionBetween(LocalDate fechaDesde, LocalDate fechaHasta);

    List<PeliculaSerieEntity> findByCalificacionGreaterThanEqualAndCalificacionLessThanEqual(Byte desde, Byte hasta);
}
