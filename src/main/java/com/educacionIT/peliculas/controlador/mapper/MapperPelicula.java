package com.educacionIT.peliculas.controlador.mapper;

import com.educacionIT.peliculas.controlador.dto.request.PeliculaDtoRequest;
import com.educacionIT.peliculas.controlador.dto.response.PeliculaDtoResponse;
import com.educacionIT.peliculas.core.dominio.PeliculaSerie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Component
@AllArgsConstructor
public class MapperPelicula {

    private final MapperPersonaje mapperPersonaje;

    public PeliculaSerie toDominio(PeliculaDtoRequest peliculaDtoRequest) {
        return PeliculaSerie.builder()
                .titulo(peliculaDtoRequest.getTitulo())
                .fechaCreacion(peliculaDtoRequest.getFechaCreacion())
                .calificacion(peliculaDtoRequest.getCalificacion())
                .build();
    }

    public PeliculaDtoResponse toDto(PeliculaSerie peliculaSerie) {
        return PeliculaDtoResponse.builder()
                .id(peliculaSerie.getId())
                .titulo(peliculaSerie.getTitulo())
                .calificacion(peliculaSerie.getCalificacion())
                .fechaCreacion(peliculaSerie.getFechaCreacion())
                .personajesAsociados(mapperPersonaje.toDto(peliculaSerie.getPersonajesAsociados()))
                .build();
    }

    public List<PeliculaDtoResponse> toDto(List<PeliculaSerie> peliculaSeries) {
        if (peliculaSeries == null) {
            return Collections.emptyList();
        }

        return peliculaSeries.stream().map(this::toDto).toList();
    }

}
