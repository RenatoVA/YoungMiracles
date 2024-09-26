package com.grupo1software.youngmiracles.controller;

import com.grupo1software.youngmiracles.dto.SesionDTO;
import com.grupo1software.youngmiracles.model.entity.Sesion;
import com.grupo1software.youngmiracles.service.AdminSesionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sesiones")
public class AdminSesionController {
    private final AdminSesionService adminSesionService;

    @PostMapping
    public ResponseEntity<SesionDTO> createSession(@RequestBody SesionDTO session) {
        SesionDTO nuevaSession = adminSesionService.createSesion(session);
        return new ResponseEntity<>(nuevaSession, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SesionDTO> getSession(@PathVariable Long id) {
        SesionDTO session = adminSesionService.getSesionById(id);
        if (session != null) {
            return new ResponseEntity<>(session, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<SesionDTO>> getAllSessions() {
        List<SesionDTO> sessions = adminSesionService.getAllSesions();
        return new ResponseEntity<>(sessions, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SesionDTO> updateSession(@PathVariable Long id, @RequestBody SesionDTO session) {
        SesionDTO updatedSession = adminSesionService.updateSesion(id, session);
        if (updatedSession != null) {
            return new ResponseEntity<>(updatedSession, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSession(@PathVariable Long id) {
        adminSesionService.deleteSesion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/adultomayor/{id}")
    public ResponseEntity<List<SesionDTO>> getSessionsByAdultoMayor(@PathVariable Long id) {
        List<SesionDTO> sessions = adminSesionService.getSesionsByAdultoMayor(id);
        return new ResponseEntity<>(sessions, HttpStatus.OK);
    }

    @GetMapping("/voluntario/{id}")
    public ResponseEntity<List<SesionDTO>> getSessionsByVoluntario(@PathVariable Long id) {
        List<SesionDTO> sessions = adminSesionService.getSesionsByVoluntario(id);
        return new ResponseEntity<>(sessions, HttpStatus.OK);
    }
}
