package com.educacionIT.peliculas.infra.database.entity;

import com.educacionIT.peliculas.core.dominio.PeliculaSerie;
import com.educacionIT.peliculas.core.dominio.Personaje;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Data
@Entity
@Builder
@Table(name = "peliculas_series")
@AllArgsConstructor
@NoArgsConstructor
public class PeliculaSerieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    private Byte calificacion;

    @OneToMany(mappedBy = "peliculaSerie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonajeEntity> personajesAsociados;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "genero_pelicula",
            joinColumns = @JoinColumn(name ="fk_pelicula_serie_id"),
            inverseJoinColumns = @JoinColumn(name ="fk_genero_id")
    )
    private List<GeneroEntity> generos;

    public static PeliculaSerie toDomain(PeliculaSerieEntity peliculaSerieEntity) {
        return PeliculaSerie.builder()
                .titulo(peliculaSerieEntity.getTitulo())
                .calificacion(peliculaSerieEntity.getCalificacion())
                .fechaCreacion(peliculaSerieEntity.getFechaCreacion())
                .personajesAsociados(mapearPersonajes(peliculaSerieEntity.getPersonajesAsociados()))
                .build();
    }

    public static List<PeliculaSerie> toDomain(List<PeliculaSerieEntity> peliculaSerieEntities) {
        if (peliculaSerieEntities == null) {
            return Collections.emptyList();
        }

        return peliculaSerieEntities.stream().map(PeliculaSerieEntity::toDomain).toList();
    }

    private static List<Personaje> mapearPersonajes(List<PersonajeEntity> personajesEntity) {
        return personajesEntity.stream()
                .map(PersonajeEntity::toDomain)
                .toList();
    }

    public static PeliculaSerieEntity toEntity(PeliculaSerie peliculaSerie) {
        return PeliculaSerieEntity.builder()
                .titulo(peliculaSerie.getTitulo())
                .calificacion(peliculaSerie.getCalificacion())
                .fechaCreacion(peliculaSerie.getFechaCreacion())
                .build();
    }

}
