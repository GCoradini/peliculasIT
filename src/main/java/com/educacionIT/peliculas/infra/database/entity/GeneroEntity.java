package com.educacionIT.peliculas.infra.database.entity;

import com.educacionIT.peliculas.core.dominio.Genero;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "genero")
public class GeneroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToMany(mappedBy = "generos")
    private List<PeliculaSerieEntity> peliculaSeries;

    public static Genero toDomain(GeneroEntity generoEntity) {
        return Genero.builder()
                .nombre(generoEntity.getNombre())
                .peliculaSerie(PeliculaSerieEntity.toDomain(generoEntity.getPeliculaSeries()))
                .build();
    }

    public static List<Genero> toDomain(List<GeneroEntity> generoEntities) {
        return generoEntities.stream().map(GeneroEntity::toDomain).toList();
    }

}
