package com.grupo1software.youngmiracles.controller;

import com.grupo1software.youngmiracles.dto.ReporteDTO;
import com.grupo1software.youngmiracles.service.AdminReporteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reportes")
public class AdminReporteController {

    private final AdminReporteService adminReporteService;


    @PostMapping
    public ResponseEntity<ReporteDTO> createReporte(@RequestBody ReporteDTO reporteDTO) {
        ReporteDTO reporte = adminReporteService.createReporte(reporteDTO);
        return new ResponseEntity<>(reporte, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReporteDTO> updateReporte(@PathVariable Long id, @Valid @RequestBody ReporteDTO reporte) {
        ReporteDTO updatereporte = adminReporteService.updateReporte(id, reporte);
        if (updatereporte != null) {
            return new ResponseEntity<>(updatereporte, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<ReporteDTO>> getReportes() {
        List<ReporteDTO> reportes=adminReporteService.getAllReportes();
        return new ResponseEntity<>(reportes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReporteDTO> getReporteById(@PathVariable Long id) {
        ReporteDTO reporte = adminReporteService.getReporteById(id);
        if (reporte != null) {
            return new ResponseEntity<>(reporte, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/adultomayor/{id}")
    public ResponseEntity<List<ReporteDTO>> getReportesByAdultoMayor(@PathVariable Long id) {
        List<ReporteDTO> reportes = adminReporteService.getReporteByAdultoMayor(id);
        return new ResponseEntity<>(reportes, HttpStatus.OK);
    }

    @GetMapping("/voluntario/{id}")
    public ResponseEntity<List<ReporteDTO>> getReportesByVoluntario(@PathVariable Long id) {
        List<ReporteDTO> reportes = adminReporteService.getReporteByVoluntario(id);
        return new ResponseEntity<>(reportes, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReporte(@PathVariable Long id) {
        adminReporteService.deleteReporte(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
