package com.educacionIT.peliculas.controlador;

import com.educacionIT.peliculas.controlador.dto.response.GeneroDtoResponse;
import com.educacionIT.peliculas.controlador.mapper.MapperGenero;
import com.educacionIT.peliculas.core.dominio.Genero;
import com.educacionIT.peliculas.core.service.GeneroService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/generos")
@AllArgsConstructor
public class GeneroController {

    private final GeneroService generoService;
    private final MapperGenero mapperGenero;

    @GetMapping()
    List<GeneroDtoResponse> obtenerTodos() {
        List<Genero> generos = generoService.findAll();
        return mapperGenero.toDto(generos);
    }

}
