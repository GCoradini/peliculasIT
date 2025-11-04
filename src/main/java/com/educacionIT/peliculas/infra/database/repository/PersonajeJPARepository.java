package com.educacionIT.peliculas.infra.database.repository;

import com.educacionIT.peliculas.infra.database.entity.PersonajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonajeJPARepository extends JpaRepository<PersonajeEntity, Long> {

    PersonajeEntity findByNombre(String nombre);

    List<PersonajeEntity> findByEdad(Integer edad);

    List<PersonajeEntity> findByEdadGreaterThanEqualAndEdadLessThanEqual(Integer desde, Integer hasta);

}
