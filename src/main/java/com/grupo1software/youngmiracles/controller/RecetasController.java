package com.grupo1software.youngmiracles.controller;

import com.grupo1software.youngmiracles.dto.RecetasDTO;
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
    public ResponseEntity<RecetasDTO> crearReceta(@RequestBody RecetasDTO recetaDTO) {
        RecetasDTO nuevaReceta = recetasService.crearReceta(recetaDTO);
        return new ResponseEntity<>(nuevaReceta, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecetasDTO> getRecetaById(@PathVariable Long id) {
        RecetasDTO receta = recetasService.getRecetaById(id);
        return new ResponseEntity<>(receta, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RecetasDTO>> getAllRecetas() {
        List<RecetasDTO> recetas = recetasService.getAllRecetas();
        return new ResponseEntity<>(recetas, HttpStatus.OK);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<RecetasDTO>> findByNombreReceta(@RequestParam String nombreReceta) {
        List<RecetasDTO> recetas = recetasService.findByNombreReceta(nombreReceta);
        if (!recetas.isEmpty()) {
            return new ResponseEntity<>(recetas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
