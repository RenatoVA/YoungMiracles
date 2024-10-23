package com.grupo1software.youngmiracles.controller;

import com.grupo1software.youngmiracles.dto.ReporteDTO;
import com.grupo1software.youngmiracles.service.ReporteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    private final ReporteService reporteService;

    @GetMapping
    public ResponseEntity<List<ReporteDTO>> getAllReportes() {
        return ResponseEntity.ok(reporteService.getAllReportes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReporteDTO> getReporteById(@PathVariable Long id) {
        return ResponseEntity.ok(reporteService.getReporteById(id));
    }

    @PostMapping
    public ResponseEntity<ReporteDTO> createReporte(@RequestBody ReporteDTO reporteDTO) {
        return ResponseEntity.ok(reporteService.createReporte(reporteDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReporteDTO> updateReporte(@PathVariable Long id, @RequestBody ReporteDTO reporteDTO) {
        return ResponseEntity.ok(reporteService.updateReporte(id, reporteDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReporte(@PathVariable Long id) {
        reporteService.deleteReporte(id);
        return ResponseEntity.noContent().build();
    }
}
