package com.grupo1software.youngmiracles.controller;


import com.grupo1software.youngmiracles.model.entity.Videollamada;
import com.grupo1software.youngmiracles.service.AdminVideollamadaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/videollamadas")
public class AdminVideollamadaController {
    private final AdminVideollamadaService adminVideollamadaService;

    @PostMapping
    public ResponseEntity<Videollamada> createVideollamada(@RequestBody Videollamada videollamada) {
        Videollamada nuevaVideollamada = adminVideollamadaService.createVideollamada(videollamada);
        return new ResponseEntity<>(nuevaVideollamada, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Videollamada> getVideollamada(@PathVariable Long id) {
        Videollamada videollamada= adminVideollamadaService.getVideollamadaById(id);
        if (videollamada != null) {
            return new ResponseEntity<>(videollamada, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Videollamada>> getAllVideollamadas() {
        List<Videollamada> videollamadas = adminVideollamadaService.getAllVideollamadas();
        return new ResponseEntity<>(videollamadas, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Videollamada> updateVideollamada(@PathVariable Long id, @RequestBody Videollamada videollamada) {
        Videollamada updatedVideollamada = adminVideollamadaService.updateVideollamada(id, videollamada);
        if (updatedVideollamada != null) {
            return new ResponseEntity<>(updatedVideollamada, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVideollamada(@PathVariable Long id) {
        adminVideollamadaService.deleteVideollamada(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/adultomayor/{id}")
    public ResponseEntity<List<Videollamada>> getVideollamadasByAdultoMayor(@PathVariable Long id) {
        List<Videollamada> videollamadas = adminVideollamadaService.getVideollamadasByAdultoMayor(id);
        return new ResponseEntity<>(videollamadas, HttpStatus.OK);
    }

    @GetMapping("/voluntario/{id}")
    public ResponseEntity<List<Videollamada>> getVideollamadasByVoluntario(@PathVariable Long id) {
        List<Videollamada> videollamadas = adminVideollamadaService.getVideollamadasByVoluntario(id);
        return new ResponseEntity<>(videollamadas, HttpStatus.OK);
    }
}
