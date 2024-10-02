package com.grupo1software.youngmiracles.controller;

import com.grupo1software.youngmiracles.model.entity.Capacitaciones;
import com.grupo1software.youngmiracles.service.CapacitacionesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/capacitaciones")
public class CapacitacionesController {

    private final CapacitacionesService capacitacionesService;

    public CapacitacionesController(CapacitacionesService capacitacionesService) {
        this.capacitacionesService = capacitacionesService;
    }

    @PostMapping
    public ResponseEntity<Capacitaciones> crearCapacitacion(@RequestBody Capacitaciones capacitacion) {
        Capacitaciones nuevaCapacitacion = capacitacionesService.crearCapacitacion(capacitacion);
        return ResponseEntity.ok(nuevaCapacitacion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Capacitaciones> getCapacitacionById(@PathVariable Long id) {
        Capacitaciones capacitacion = capacitacionesService.getCapacitacionById(id);
        return ResponseEntity.ok(capacitacion);
    }

    @GetMapping
    public ResponseEntity<List<Capacitaciones>> getAllCapacitaciones() {
        List<Capacitaciones> capacitaciones = capacitacionesService.getAllCapacitaciones();
        return ResponseEntity.ok(capacitaciones);
    }
}
