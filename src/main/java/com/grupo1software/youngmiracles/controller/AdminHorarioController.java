package com.grupo1software.youngmiracles.controller;

import com.grupo1software.youngmiracles.dto.CreateUpdateHorarioDTO;
import com.grupo1software.youngmiracles.dto.HorarioResponseDTO;
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
@CrossOrigin(origins={"http://localhost:4200/"})
public class AdminHorarioController {
    private final AdminHorarioService adminHorarioService;

    @PostMapping
    public ResponseEntity<HorarioResponseDTO> createHorario(@Valid @RequestBody CreateUpdateHorarioDTO horario) {
        HorarioResponseDTO nuevoHorario = adminHorarioService.createHorario(horario);
        return new ResponseEntity<>(nuevoHorario, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<HorarioResponseDTO> getHorario(@PathVariable Long id) {
        HorarioResponseDTO horario = adminHorarioService.getHorarioById(id);
        if (horario != null) {
            return new ResponseEntity<>(horario, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping
    public ResponseEntity<List<HorarioResponseDTO>> getAllHorarios() {
        List<HorarioResponseDTO> horarios = adminHorarioService.getAllHorarios();
        return new ResponseEntity<>(horarios, HttpStatus.OK);
    }

    @GetMapping("/especialidad/{especialidad}")
    public ResponseEntity<List<HorarioResponseDTO>> getAllHorariosByEspecialidad(@PathVariable String especialidad) {
        List<HorarioResponseDTO> horarios = adminHorarioService.getHorariosByespecialidad(especialidad);
        return new ResponseEntity<>(horarios, HttpStatus.OK);
    }

    @GetMapping("/voluntario/{voluntarioId}")
    public ResponseEntity<List<HorarioResponseDTO>> getHorariosByVoluntarioId(@PathVariable Long voluntarioId) {
        List<HorarioResponseDTO> horarios = adminHorarioService.getHorariosByVoluntario(voluntarioId);
        return new ResponseEntity<>(horarios, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorarioResponseDTO> updateHorario(@PathVariable Long id, @Valid @RequestBody CreateUpdateHorarioDTO horario) {
        HorarioResponseDTO updatedhorario = adminHorarioService.updateHorario(id, horario);
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
