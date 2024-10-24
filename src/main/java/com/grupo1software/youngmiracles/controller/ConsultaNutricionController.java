package com.grupo1software.youngmiracles.controller;

import com.grupo1software.youngmiracles.dto.ConsultaNutricionDTO;
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
    public ResponseEntity<ConsultaNutricionDTO> crearConsulta(@RequestBody ConsultaNutricionDTO consultaNutricionDTO) {
        ConsultaNutricionDTO nuevaConsulta = consultaNutricionService.crearConsulta(consultaNutricionDTO);
        return new ResponseEntity<>(nuevaConsulta, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaNutricionDTO> getConsultaById(@PathVariable Long id) {
        ConsultaNutricionDTO consulta = consultaNutricionService.getConsultaById(id);
        return new ResponseEntity<>(consulta, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ConsultaNutricionDTO>> getAllConsultas() {
        List<ConsultaNutricionDTO> consultas = consultaNutricionService.getAllConsultas();
        return new ResponseEntity<>(consultas, HttpStatus.OK);
    }

    @GetMapping("/adultomayor/{adultoMayorId}")
    public ResponseEntity<List<ConsultaNutricionDTO>> listarConsultasPorAdultoMayor(@PathVariable Long adultoMayorId) {
        List<ConsultaNutricionDTO> consultas = consultaNutricionService.listarConsultasPorAdultoMayor(adultoMayorId);
        return new ResponseEntity<>(consultas, HttpStatus.OK);
    }
}

