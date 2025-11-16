package com.educacionIT.peliculas.controlador;

import com.educacionIT.peliculas.controlador.dto.request.PersonajeDtoRequest;
import com.educacionIT.peliculas.controlador.dto.response.PersonajeDtoResponse;
import com.educacionIT.peliculas.controlador.mapper.MapperPersonaje;
import com.educacionIT.peliculas.core.dominio.Personaje;
import com.educacionIT.peliculas.core.service.PersonajeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/personajes")
@AllArgsConstructor
public class PersonajeController {

    private final PersonajeService personajeService;
    private final MapperPersonaje mapperPersonaje;

    @GetMapping()
    List<PersonajeDtoResponse> obtenerTodos() {
        List<Personaje> personajes = personajeService.findAll();
        return mapperPersonaje.toDto(personajes);
    }

    @GetMapping("/nombre/{nombre}")
    PersonajeDtoResponse obtenerPersonaje(@PathVariable String nombre) {
        Personaje personaje = personajeService.findByName(nombre);
        return mapperPersonaje.toDto(personaje);
    }

    @GetMapping("/edad/{edad}")
    List<PersonajeDtoResponse> obtenerPersonajesPorEdad(@PathVariable Integer edad) {
        List<Personaje> personajes = personajeService.findByAge(edad);
        return mapperPersonaje.toDto(personajes);
    }

    @GetMapping("/edad")
    List<PersonajeDtoResponse> obtenerPersonajesRangoEdad(@RequestParam(name = "desde") Integer edadDesde,
                                                          @RequestParam(name = "hasta") Integer edadHasta) {
        List<Personaje> personajes = personajeService.findBetweenAge(edadDesde, edadHasta);
        return mapperPersonaje.toDto(personajes);
    }

    @PostMapping
    PersonajeDtoResponse guardarPersonaje(@RequestBody PersonajeDtoRequest personajeDtoRequest) {
        Personaje personaje = personajeService.save(mapperPersonaje.toDominio(personajeDtoRequest));
        return mapperPersonaje.toDto(personaje);
    }

    @PutMapping("{id}")
    PersonajeDtoResponse actualizarPersonaje(
            @PathVariable Long id,
            @RequestBody PersonajeDtoRequest personajeDtoRequest) {
        personajeService.findById(id);

        Personaje personaje = mapperPersonaje.toDominio(personajeDtoRequest);
        personaje.setId(id);

        Personaje personajeActualizado = personajeService.save(personaje);
        return mapperPersonaje.toDto(personajeActualizado);
    }
}
