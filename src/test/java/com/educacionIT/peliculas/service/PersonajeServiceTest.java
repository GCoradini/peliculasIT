package com.educacionIT.peliculas.service;

import com.educacionIT.peliculas.infra.database.entity.PeliculaSerieEntity;
import com.educacionIT.peliculas.infra.database.entity.PersonajeEntity;
import com.educacionIT.peliculas.infra.database.repository.PersonajeJPARepository;
import com.educacionIT.peliculas.infra.impl.PersonajeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PersonajeServiceTest {

    @Mock
    private PersonajeJPARepository personajeJPARepository;

    @InjectMocks
    private PersonajeServiceImpl personajeService;

    private PersonajeEntity personaje;

    @BeforeEach
    void setup() {
        PeliculaSerieEntity pelicula = PeliculaSerieEntity.builder()
                .id(1L)
                .titulo("Película Test")
                .build();

        personaje = PersonajeEntity.builder()
                .nombre("Pepe")
                .edad(90)
                .peso(50.0)
                .historia("Es un personaje")
                .peliculaSerie(pelicula)
                .build();

    }
}
