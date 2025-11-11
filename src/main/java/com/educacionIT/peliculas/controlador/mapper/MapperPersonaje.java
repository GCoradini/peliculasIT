package com.educacionIT.peliculas.controlador.mapper;

import com.educacionIT.peliculas.controlador.dto.request.PersonajeDtoRequest;
import com.educacionIT.peliculas.controlador.dto.response.PersonajeDtoResponse;
import com.educacionIT.peliculas.core.dominio.Personaje;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;


@Component
public class MapperPersonaje {

    public PersonajeDtoResponse toDto(Personaje personaje){
        return PersonajeDtoResponse.builder()
                .nombre(personaje.getNombre())
                .edad(personaje.getEdad())
                .peso(personaje.getPeso())
                .historia(personaje.getHistoria())
                .build();
    }

    public List<PersonajeDtoResponse> toDto(List<Personaje> personajes) {
        if (personajes == null) {
            return Collections.emptyList();
        }

        return personajes.stream().map(this::toDto).toList();
    }


    public Personaje toDominio(PersonajeDtoRequest personajeDtoRequest) {
        return Personaje.builder()
                .nombre(personajeDtoRequest.getNombre())
                .edad(personajeDtoRequest.getEdad())
                .peso(personajeDtoRequest.getPeso())
                .historia(personajeDtoRequest.getHistoria())
                .build();
    }
}
