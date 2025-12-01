package com.educacionIT.peliculas.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

import com.educacionIT.peliculas.core.dominio.Personaje;
import com.educacionIT.peliculas.infra.database.entity.PersonajeEntity;
import com.educacionIT.peliculas.infra.database.repository.PersonajeJPARepository;
import com.educacionIT.peliculas.infra.exception.PersonajeNotFoundException;
import com.educacionIT.peliculas.infra.impl.PersonajeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PersonajeServiceTest {

    @Mock
    private PersonajeJPARepository personajeRepository;

    @InjectMocks
    private PersonajeServiceImpl personajeService;

    private PersonajeEntity personajeEntity;
    private Personaje personaje;

    @BeforeEach
    void setup() {
        personajeEntity = PersonajeEntity.builder()
                .nombre("Pepe")
                .edad(90)
                .peso(50.0)
                .historia("Es un personaje")
                .build();

        personaje = PersonajeEntity.toDomain(personajeEntity);
    }

    @DisplayName("Test para guardar un personaje")
    @Test
    void testGuardarPersonaje() {
        given(personajeRepository.save(personajeEntity)).willReturn(personajeEntity);

        Personaje personajeGuardado = personajeService.save(personaje);

        assertThat(personajeGuardado).isNotNull();
        assertThat(personajeGuardado.getNombre()).isEqualTo("Pepe");

        then(personajeRepository).should().save(personajeEntity);
    }

    @DisplayName("Test para obtener todos los personajes")
    @Test
    void testObtenerTodosLosPersonajes() {
        PersonajeEntity personaje2 = PersonajeEntity.builder()
                .nombre("Maria")
                .edad(32)
                .peso(47.0)
                .historia("Es un personaje 2")
                .build();

        given(personajeRepository.findAll()).willReturn(List.of(personajeEntity, personaje2));

        List<Personaje> listaPersonajes = personajeService.findAll();

        assertThat(listaPersonajes.size()).isEqualTo(2);
    }

    @DisplayName("Test para obtener un personaje por ID")
    @Test
    void testObtenerPersonajePorId() {
        given(personajeRepository.findById(1L)).willReturn(Optional.of(personajeEntity));

        Personaje personajeBuscado = personajeService.findById(1L);

        assertThat(personajeBuscado).isNotNull();
        assertThat(personajeBuscado.getNombre()).isEqualTo("Pepe");
    }

    @DisplayName("Test para obtener un personaje inexistente por ID")
    @Test
    void testObtenerPersonajeInexistentePorId() {
        Long idInexistente = 99L;

        given(personajeRepository.findById(idInexistente)).willReturn(Optional.empty());

        assertThatThrownBy(() -> personajeService.findById(idInexistente))
                .isInstanceOf(PersonajeNotFoundException.class)
                .hasMessageContaining("No se encontro el personaje con id: " + idInexistente);

        then(personajeRepository).should(times(1)).findById(idInexistente);
    }

    @DisplayName("Test para actualizar un personaje")
    @Test
    void testActualizarPersonaje() {
        given(personajeRepository.save(personajeEntity)).willReturn(personajeEntity);

        personajeEntity.setNombre("Gonza");
        personajeEntity.setEdad(30);

        Personaje personajeActualizado = personajeService.save(PersonajeEntity.toDomain(personajeEntity));

        assertThat(personajeActualizado).isNotNull();
        assertThat(personajeActualizado.getNombre()).isEqualTo("Gonza");
        assertThat(personajeActualizado.getEdad()).isEqualTo(30);
        assertThat(personajeActualizado.getHistoria()).isEqualTo(personajeEntity.getHistoria());

        then(personajeRepository).should().save(personajeEntity);
    }

}
