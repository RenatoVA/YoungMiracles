package com.grupo1software.youngmiracles.controller;

import com.grupo1software.youngmiracles.model.entity.Progreso;
import com.grupo1software.youngmiracles.service.AdminProgresoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/progresos")
public class AdminProgresoController {
    private final AdminProgresoService adminProgresoService;

    @PostMapping
    public ResponseEntity<Progreso> createProgreso(@Valid  @RequestBody Progreso horario) {
        Progreso nuevoprogreso = adminProgresoService.createProgreso(horario);
        return new ResponseEntity<>(nuevoprogreso, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Progreso> getProgreso(@PathVariable Long id) {
        Progreso progreso = adminProgresoService.getProgresoById(id);
        if (progreso != null) {
            return new ResponseEntity<>(progreso, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping
    public ResponseEntity<List<Progreso>> getAllProgresos() {
        List<Progreso> progresos = adminProgresoService.getAllProgresos();
        return new ResponseEntity<>(progresos, HttpStatus.OK);
    }

    @GetMapping("/sesion/{sesionId}")
    public ResponseEntity<List<Progreso>> getHorariosByVoluntarioId(@PathVariable Long sesionId) {
        List<Progreso> progresos = adminProgresoService.getProgresosBySesion(sesionId);
        return new ResponseEntity<>(progresos, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Progreso> updateProgreso(@PathVariable Long id, @Valid @RequestBody Progreso progreso) {
        Progreso updatedprogreso = adminProgresoService.updateProgreso(id, progreso);
        if (updatedprogreso != null) {
            return new ResponseEntity<>(updatedprogreso, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgreso(@PathVariable Long id) {
        adminProgresoService.deleteProgreso(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
