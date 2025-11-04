package com.educacionIT.peliculas.controlador;

import com.educacionIT.peliculas.controlador.dto.request.PeliculaDtoRequest;
import com.educacionIT.peliculas.controlador.dto.response.PeliculaDtoResponse;
import com.educacionIT.peliculas.controlador.mapper.MapperPelicula;
import com.educacionIT.peliculas.core.dominio.PeliculaSerie;
import com.educacionIT.peliculas.core.service.PeliculaSerieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/peliculas")
@AllArgsConstructor
public class PeliculasController {

    private final PeliculaSerieService peliculaSerieService;
    private final MapperPelicula mapperPelicula;

    @GetMapping()
    List<PeliculaDtoResponse> obtenerTodos() {
        List<PeliculaSerie> peliculaSeries = peliculaSerieService.findAll();
        return mapperPelicula.toDto(peliculaSeries);
    }

    @GetMapping("/titulo/{titulo}")
    PeliculaDtoResponse obtenerPorTitulo(@PathVariable String titulo) {
        PeliculaSerie peliculaSerie = peliculaSerieService.findByTitulo(titulo);
        return mapperPelicula.toDto(peliculaSerie);
    }

    @GetMapping("/genero/{genero}")
    List<PeliculaDtoResponse> obtenerPorGenero(@PathVariable String genero) {
        List<PeliculaSerie> peliculaSeries = peliculaSerieService.findByGenero(genero);
        return mapperPelicula.toDto(peliculaSeries);
    }

    @GetMapping("/fechas")
    List<PeliculaDtoResponse> obtenerPorFecha(@RequestParam(name = "desde") LocalDate fechaDesde,
                                              @RequestParam(name = "hasta") LocalDate fechaHasta) {
        List<PeliculaSerie> peliculas = peliculaSerieService.findByFecha(fechaDesde, fechaHasta);
        return mapperPelicula.toDto(peliculas);
    }

    @GetMapping("/calificacion")
    List<PeliculaDtoResponse> obtenerPorCalificacion(@RequestParam(name = "desde") Byte desde,
                                                     @RequestParam(name = "hasta") Byte hasta) {
        List<PeliculaSerie> peliculas = peliculaSerieService.findByCalificacion(desde, hasta);
        return mapperPelicula.toDto(peliculas);
    }

    @PostMapping
    PeliculaDtoResponse guardarPelicula(@RequestBody PeliculaDtoRequest peliculaDtoRequest) {
        PeliculaSerie peliculaSerie = peliculaSerieService.save(mapperPelicula.toDominio(peliculaDtoRequest));
        return mapperPelicula.toDto(peliculaSerie);
    }

}
