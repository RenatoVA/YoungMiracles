package com.grupo1software.youngmiracles.controller;

import com.grupo1software.youngmiracles.dto.CapacitacionDTO;
import com.grupo1software.youngmiracles.service.CapacitacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/capacitaciones")
public class CapacitacionController {

    private final CapacitacionService capacitacionService;

    @GetMapping
    public ResponseEntity<List<CapacitacionDTO>> getAllCapacitaciones() {
        return ResponseEntity.ok(capacitacionService.getAllCapacitaciones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CapacitacionDTO> getCapacitacionById(@PathVariable Long id) {
        return ResponseEntity.ok(capacitacionService.getCapacitacionById(id));
    }

    @PostMapping
    public ResponseEntity<CapacitacionDTO> createCapacitacion(@RequestBody CapacitacionDTO capacitacionDTO) {
        return ResponseEntity.ok(capacitacionService.createCapacitacion(capacitacionDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CapacitacionDTO> updateCapacitacion(@PathVariable Long id, @RequestBody CapacitacionDTO capacitacionDTO) {
        return ResponseEntity.ok(capacitacionService.updateCapacitacion(id, capacitacionDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCapacitacion(@PathVariable Long id) {
        capacitacionService.deleteCapacitacion(id);
        return ResponseEntity.noContent().build();
    }
}
