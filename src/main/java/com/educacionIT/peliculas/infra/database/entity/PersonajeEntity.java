package com.educacionIT.peliculas.infra.database.entity;

import com.educacionIT.peliculas.core.dominio.Personaje;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
@Table(name = "personajes")
public class PersonajeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Integer edad;
    private Double peso;
    private String historia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_pelicula_serie_id")
    private PeliculaSerieEntity peliculaSerie;

    public static Personaje toDomain(PersonajeEntity personajeEntity) {
        return Personaje.builder()
                .nombre(personajeEntity.getNombre())
                .edad(personajeEntity.getEdad())
                .peso(personajeEntity.getPeso())
                .historia(personajeEntity.historia)
                .build();
    }

    public static List<Personaje> toDomain(List<PersonajeEntity> personajeEntityList) {
        return personajeEntityList.stream().map(PersonajeEntity::toDomain).toList();
    }

}
