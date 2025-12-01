package com.educacionIT.peliculas.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.educacionIT.peliculas.infra.database.entity.PeliculaSerieEntity;
import com.educacionIT.peliculas.infra.database.entity.PersonajeEntity;
import com.educacionIT.peliculas.infra.database.repository.PersonajeJPARepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class PersonajeRepositoryTest {

    @Autowired
    private PersonajeJPARepository personajeJPARepository;

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

    @DisplayName("Test para guardar un personaje")
    @Test
    void testGuardarPersonaje() {
        PersonajeEntity personajeGuardado = personajeJPARepository.save(personaje);

        assertThat(personajeGuardado).isNotNull();
        assertThat(personajeGuardado.getNombre()).isEqualTo("Pepe");
        assertThat(personajeGuardado.getEdad()).isEqualTo(90);
        assertThat(personajeGuardado.getPeso()).isEqualTo(50.0);
        assertThat(personajeGuardado.getHistoria()).isEqualTo("Es un personaje");
    }

    @DisplayName("Test para obtener todos los personajes")
    @Test
    void testObtenerTodosPersonajes() {
        personajeJPARepository.save(personaje);

        List<PersonajeEntity> personajesEncontrados = personajeJPARepository.findAll();

        assertThat(personajesEncontrados).isNotNull();
        assertThat(personajesEncontrados.size()).isEqualTo(21);
    }

    @DisplayName("Test para obtener un personaje por ID")
    @Test
    void testObtenerPersonajePorId() {
        personajeJPARepository.save(personaje);

        PersonajeEntity personajeEncontrado = personajeJPARepository.findById(personaje.getId()).get();

        assertThat(personajeEncontrado).isNotNull();
        assertThat(personajeEncontrado.getNombre()).isEqualTo("Pepe");
        assertThat(personajeEncontrado.getEdad()).isEqualTo(90);
        assertThat(personajeEncontrado.getPeso()).isEqualTo(50.0);
        assertThat(personajeEncontrado.getHistoria()).isEqualTo("Es un personaje");
    }

    @DisplayName("Test para obtener personajes por Edad")
    @Test
    void testObtenerPersonajePorEdad() {
        personajeJPARepository.save(personaje);

        List<PersonajeEntity> personajesEncontrados = personajeJPARepository.findByEdad(personaje.getEdad());

        assertThat(personajesEncontrados).isNotNull();
        assertThat(personajesEncontrados.size()).isGreaterThan(0);
    }

    @DisplayName("Test para obtener personajes en un rango de edad")
    @Test
    void testObtenerPersonajePorRangoEdad() {
        personajeJPARepository.save(personaje);

        List<PersonajeEntity> personajesEncontrados = personajeJPARepository.findByEdadGreaterThanEqualAndEdadLessThanEqual(90,100);

        assertThat(personajesEncontrados).isNotNull();
        assertThat(personajesEncontrados.size()).isGreaterThan(0);
    }

    @DisplayName("Test para actualizar un personaje")
    @Test
    void testActualizarPersonaje() {
        personajeJPARepository.save(personaje);

        PersonajeEntity personajeBuscado = personajeJPARepository.findById(personaje.getId()).get();
        personajeBuscado.setEdad(40);
        personajeBuscado.setNombre("Mariano");

        PersonajeEntity personajeActualizado = personajeJPARepository.save(personajeBuscado);

        assertThat(personajeActualizado).isNotNull();
        assertThat(personajeActualizado.getEdad()).isEqualTo(40);
        assertThat(personajeActualizado.getNombre()).isEqualTo("Mariano");
    }
}
