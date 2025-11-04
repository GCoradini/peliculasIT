package com.educacionIT.peliculas.controlador.mapper;

import com.educacionIT.peliculas.controlador.dto.response.GeneroDtoResponse;
import com.educacionIT.peliculas.core.dominio.Genero;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class MapperGenero {

    private final MapperPelicula mapperPelicula;

    public GeneroDtoResponse toDto(Genero genero) {
        return GeneroDtoResponse.builder()
                .nombre(genero.getNombre())
                .peliculaSerie(mapperPelicula.toDto(genero.getPeliculaSerie()))
                .build();
    }

    public List<GeneroDtoResponse> toDto(List<Genero> generos) {
        return generos.stream().map(this::toDto).toList();
    }

}
