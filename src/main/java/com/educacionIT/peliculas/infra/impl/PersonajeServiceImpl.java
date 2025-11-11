package com.educacionIT.peliculas.infra.impl;

import com.educacionIT.peliculas.core.dominio.Personaje;
import com.educacionIT.peliculas.core.service.PersonajeService;
import com.educacionIT.peliculas.infra.database.entity.PersonajeEntity;
import com.educacionIT.peliculas.infra.database.repository.PersonajeJPARepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonajeServiceImpl implements PersonajeService {

    private final PersonajeJPARepository personajeJPARepository;

    @Override
    public List<Personaje> findAll() {
        log.info("Obtengo todos los personajes");
        List<PersonajeEntity> personajeEntities = personajeJPARepository.findAll();
        return PersonajeEntity.toDomain(personajeEntities);
    }

    @Override
    public Personaje findByName(String nombre) {
        log.info("Obteniendo el personaje con nombre {}", nombre);
        PersonajeEntity personajeEntity = personajeJPARepository.findByNombre(nombre);
        return PersonajeEntity.toDomain(personajeEntity);
    }

    @Override
    public List<Personaje> findByAge(Integer edad) {
        log.info("Obteniendo el personaje con edad {}", edad);
        List<PersonajeEntity> personajeEntity = personajeJPARepository.findByEdad(edad);
        return PersonajeEntity.toDomain(personajeEntity);
    }

    @Override
    public List<Personaje> findBetweenAge(Integer edadDesde, Integer edadHasta) {
        log.info("Obteniendo el personaje con rango de edad {} - {}", edadDesde, edadHasta);
        List<PersonajeEntity> personajeEntity = personajeJPARepository.findByEdadGreaterThanEqualAndEdadLessThanEqual(edadDesde, edadHasta);
        return PersonajeEntity.toDomain(personajeEntity);
    }

    @Override
    public Personaje save(Personaje personaje) {
        personajeJPARepository.save(PersonajeEntity.toEntity(personaje));
        return personaje;
    }
}
