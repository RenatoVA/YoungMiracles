package com.grupo1software.youngmiracles.controller;


import com.grupo1software.youngmiracles.model.entity.AlertaAdultoMayor;
import com.grupo1software.youngmiracles.service.AlertaAdultoMayorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alertas")
public class AlertaAdultoMayorController {
    private final AlertaAdultoMayorService alertaAdultoMayorService;

    @PostMapping
    public ResponseEntity<AlertaAdultoMayor> createAlerta(@RequestBody AlertaAdultoMayor alertaAdultoMayor) {
        AlertaAdultoMayor nuevaAlerta = alertaAdultoMayorService.crearAlerta(alertaAdultoMayor);
        return new ResponseEntity<>(nuevaAlerta, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertaAdultoMayor> getAlerta(@PathVariable Long id) {
        AlertaAdultoMayor alerta = alertaAdultoMayorService.getAlertaById(id);
        if (alerta != null) {
            return new ResponseEntity<>(alerta, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<AlertaAdultoMayor>> getAllAlertas() {
        List<AlertaAdultoMayor> alertas = alertaAdultoMayorService.getAllAlertas();
        return new ResponseEntity<>(alertas, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlerta(@PathVariable Long id) {
        alertaAdultoMayorService.deleteAlerta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/adultomayor/{adultoMayorId}")
    public ResponseEntity<List<AlertaAdultoMayor>> listarAlertasPorAdultoMayor(@PathVariable Long adultoMayorId) {
        List<AlertaAdultoMayor> alertas = alertaAdultoMayorService.listarAlertasPorAdultoMayor(adultoMayorId);
        return new ResponseEntity<>(alertas, HttpStatus.OK);
    }
}
