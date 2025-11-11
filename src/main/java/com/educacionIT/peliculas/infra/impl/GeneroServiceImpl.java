package com.educacionIT.peliculas.infra.impl;

import com.educacionIT.peliculas.core.dominio.Genero;
import com.educacionIT.peliculas.core.service.GeneroService;
import com.educacionIT.peliculas.infra.database.entity.GeneroEntity;
import com.educacionIT.peliculas.infra.database.repository.GeneroJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    GeneroJPARepository generoJPARepository;

    @Override
    public List<Genero> findAll() {
        List<GeneroEntity> generoEntities = generoJPARepository.findAll();
        return GeneroEntity.toDomain(generoEntities);
    }

    @Override
    public Genero save(Genero genero) {
        GeneroEntity savedEntity = generoJPARepository.save(GeneroEntity.toEntity(genero));
        return GeneroEntity.toDomain(savedEntity);
    }
}
