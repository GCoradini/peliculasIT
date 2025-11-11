package com.educacionIT.peliculas.controlador.mapper;

import com.educacionIT.peliculas.controlador.dto.request.GeneroDtoRequest;
import com.educacionIT.peliculas.controlador.dto.request.PeliculaDtoRequest;
import com.educacionIT.peliculas.controlador.dto.response.GeneroDtoResponse;
import com.educacionIT.peliculas.core.dominio.Genero;
import com.educacionIT.peliculas.core.dominio.PeliculaSerie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class MapperGenero {

    private final MapperPelicula mapperPelicula;

    public Genero toDominio(GeneroDtoRequest generoDtoRequest) {
        return Genero.builder()
                .nombre(generoDtoRequest.getNombre())
                .build();
    }

    public GeneroDtoResponse toDto(Genero genero) {
        return GeneroDtoResponse.builder()
                .id(genero.getId())
                .nombre(genero.getNombre())
                .peliculaSerie(mapperPelicula.toDto(genero.getPeliculaSerie()))
                .build();
    }

    public List<GeneroDtoResponse> toDto(List<Genero> generos) {
        return generos.stream().map(this::toDto).toList();
    }

}
