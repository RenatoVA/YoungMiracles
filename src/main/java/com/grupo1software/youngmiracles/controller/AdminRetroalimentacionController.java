package com.grupo1software.youngmiracles.controller;

import com.grupo1software.youngmiracles.dto.RetroalimentacionDTO;
import com.grupo1software.youngmiracles.service.AdminRetroalimentacionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/retroalimentaciones")
public class AdminRetroalimentacionController {

    private final AdminRetroalimentacionService adminRetroalimentacionService;

    @PostMapping
    public ResponseEntity<RetroalimentacionDTO> createRetroalimentacion(@Valid @RequestBody RetroalimentacionDTO retroalimentacionDTO) {
        RetroalimentacionDTO nuevaretroalimentacion = adminRetroalimentacionService.createRetroalimentacion(retroalimentacionDTO);
        return new ResponseEntity<>(nuevaretroalimentacion, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<RetroalimentacionDTO> getRetroalimentacion(@PathVariable Long id) {
        RetroalimentacionDTO retroalimentacion = adminRetroalimentacionService.getRetroalimentacionById(id);
        if (retroalimentacion != null) {
            return new ResponseEntity<>(retroalimentacion, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<RetroalimentacionDTO> updateRetroalimentacion(@PathVariable Long id, @Valid @RequestBody RetroalimentacionDTO retroalimentacion) {
        RetroalimentacionDTO updateretroalimentacion = adminRetroalimentacionService.updateRetroalimentacion(id, retroalimentacion);
        if (updateretroalimentacion != null) {
            return new ResponseEntity<>(updateretroalimentacion, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteretroalimentacion(@PathVariable Long id) {
        adminRetroalimentacionService.deleteRetroalimentacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
