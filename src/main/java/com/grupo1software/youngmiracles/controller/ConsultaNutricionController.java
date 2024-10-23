package com.grupo1software.youngmiracles.controller;

import com.grupo1software.youngmiracles.model.entity.ConsultaNutricion;
import com.grupo1software.youngmiracles.service.ConsultaNutricionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultanutricion")
@RequiredArgsConstructor
public class ConsultaNutricionController {

    private final ConsultaNutricionService consultaNutricionService;

    @PostMapping
    public ResponseEntity<ConsultaNutricion> crearConsulta(@RequestBody ConsultaNutricion consultaNutricion) {
        ConsultaNutricion nuevaConsulta = consultaNutricionService.createConsulta(consultaNutricion);
        return new ResponseEntity<>(nuevaConsulta, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaNutricion> getConsulta(@PathVariable Long id) {
        ConsultaNutricion consulta = consultaNutricionService.getConsultaById(id);
        if (consulta != null) {
            return new ResponseEntity<>(consulta, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<ConsultaNutricion>> getAllConsultas() {
        List<ConsultaNutricion> consultas = consultaNutricionService.getAllConsultas();
        return new ResponseEntity<>(consultas, HttpStatus.OK);
    }

    @GetMapping("/adultomayor/{adultoMayorId}")
    public ResponseEntity<List<ConsultaNutricion>> listarConsultasPorAdultoMayor(@PathVariable Long adultoMayorId) {
        List<ConsultaNutricion> consultas = consultaNutricionService.listarConsultasPorAdultoMayor(adultoMayorId);
        return new ResponseEntity<>(consultas, HttpStatus.OK);
    }
}
