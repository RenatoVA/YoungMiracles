package com.grupo1software.youngmiracles.controller;

import com.grupo1software.youngmiracles.dto.ReporteVoluntarioResponseDTO;
import com.grupo1software.youngmiracles.dto.SesionCreateUpdateDTO;
import com.grupo1software.youngmiracles.dto.SesionResponseDTO;
import com.grupo1software.youngmiracles.dto.SesionUpdateStateDTO;
import com.grupo1software.youngmiracles.service.AdminSesionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sesiones")
@PreAuthorize("hasAnyRole('ADMIN', 'CUSTOMER')")

public class AdminSesionController {
    private final AdminSesionService adminSesionService;

    @PostMapping
    public ResponseEntity<SesionResponseDTO> createSession(@Valid @RequestBody SesionCreateUpdateDTO session) {
        SesionResponseDTO nuevaSession = adminSesionService.createSesion(session);
        return new ResponseEntity<>(nuevaSession, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SesionResponseDTO> getSession(@PathVariable Long id) {
        SesionResponseDTO session = adminSesionService.getSesionById(id);
        if (session != null) {
            return new ResponseEntity<>(session, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/reporte/{id}")
    public ResponseEntity<ReporteVoluntarioResponseDTO> getSessionReport(@PathVariable Long id) {
        ReporteVoluntarioResponseDTO reporte=adminSesionService.generarReportePorVoluntario(id);
        return new ResponseEntity<>(reporte, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SesionResponseDTO>> getAllSessions() {
        List<SesionResponseDTO> sessions = adminSesionService.getAllSesions();
        return new ResponseEntity<>(sessions, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SesionResponseDTO> updateSession(@PathVariable Long id, @Valid @RequestBody SesionCreateUpdateDTO session) {
        SesionResponseDTO updatedSession = adminSesionService.updateSesion(id, session);
        if (updatedSession != null) {
            return new ResponseEntity<>(updatedSession, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PatchMapping("/state")
    public ResponseEntity<SesionUpdateStateDTO> updateState(@Valid @RequestBody SesionUpdateStateDTO sesionUpdateStateDTO)
    {
        adminSesionService.updateSesionState(sesionUpdateStateDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSession(@PathVariable Long id) {
        adminSesionService.deleteSesion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/adultomayor/{id}")
    public ResponseEntity<List<SesionResponseDTO>> getSessionsByAdultoMayor(@PathVariable Long id) {
        List<SesionResponseDTO> sessions = adminSesionService.getSesionsByAdultoMayor(id);
        return new ResponseEntity<>(sessions, HttpStatus.OK);
    }

    @GetMapping("/voluntario/{id}")
    public ResponseEntity<List<SesionResponseDTO>> getSessionsByVoluntario(@PathVariable Long id) {
        List<SesionResponseDTO> sessions = adminSesionService.getSesionsByVoluntario(id);
        return new ResponseEntity<>(sessions, HttpStatus.OK);
    }
}
