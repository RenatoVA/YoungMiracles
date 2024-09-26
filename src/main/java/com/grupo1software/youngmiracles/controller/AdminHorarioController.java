package com.grupo1software.youngmiracles.controller;

import com.grupo1software.youngmiracles.model.entity.Horario;
import com.grupo1software.youngmiracles.service.AdminHorarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/horarios")
public class AdminHorarioController {
    private final AdminHorarioService adminHorarioService;

    @PostMapping
    public ResponseEntity<Horario> createHorario(@Valid @RequestBody Horario horario) {
        Horario nuevoHorario = adminHorarioService.createHorario(horario);
        return new ResponseEntity<>(nuevoHorario, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Horario> getHorario(@PathVariable Long id) {
        Horario horario = adminHorarioService.getHorarioById(id);
        if (horario != null) {
            return new ResponseEntity<>(horario, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping
    public ResponseEntity<List<Horario>> getAllHorarios() {
        List<Horario> horarios = adminHorarioService.getAllHorarios();
        return new ResponseEntity<>(horarios, HttpStatus.OK);
    }

    @GetMapping("/voluntario/{voluntarioId}")
    public ResponseEntity<List<Horario>> getHorariosByVoluntarioId(@PathVariable Long voluntarioId) {
        List<Horario> horarios = adminHorarioService.getHorariosByVoluntario(voluntarioId);
        return new ResponseEntity<>(horarios, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Horario> updateHorario(@PathVariable Long id, @Valid @RequestBody Horario horario) {
        Horario updatedhorario = adminHorarioService.updateHorario(id, horario);
        if (updatedhorario != null) {
            return new ResponseEntity<>(updatedhorario, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHorario(@PathVariable Long id) {
        adminHorarioService.deleteHorario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
