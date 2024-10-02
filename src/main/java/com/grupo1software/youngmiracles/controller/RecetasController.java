package com.grupo1software.youngmiracles.controller;

import com.grupo1software.youngmiracles.model.entity.Recetas;
import com.grupo1software.youngmiracles.service.RecetasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recetas")
@RequiredArgsConstructor
public class RecetasController {
    private final RecetasService recetasService;

    @PostMapping
    public ResponseEntity<Recetas> crearReceta(@RequestBody Recetas receta) {
        Recetas nuevaReceta = recetasService.crearReceta(receta);
        return new ResponseEntity<>(nuevaReceta, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recetas> getRecetaById(@PathVariable Long id) {
        Recetas receta = recetasService.getRecetaById(id);
        if (receta != null) {
            return new ResponseEntity<>(receta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Recetas>> getAllRecetas() {
        List<Recetas> recetas = recetasService.getAllRecetas();
        return new ResponseEntity<>(recetas, HttpStatus.OK);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Recetas>> findByNombreReceta(@RequestParam String nombreReceta) {
        List<Recetas> recetas = recetasService.findByNombreReceta(nombreReceta);
        if (!recetas.isEmpty()) {
            return new ResponseEntity<>(recetas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
