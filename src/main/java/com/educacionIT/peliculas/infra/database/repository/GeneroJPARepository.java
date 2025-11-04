package com.educacionIT.peliculas.infra.database.repository;

import com.educacionIT.peliculas.infra.database.entity.GeneroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroJPARepository extends JpaRepository<GeneroEntity, Long> {
}
