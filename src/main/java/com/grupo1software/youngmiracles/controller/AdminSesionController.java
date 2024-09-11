package com.grupo1software.youngmiracles.controller;

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
    public ResponseEntity<Sesion> createSession(@RequestBody Sesion session) {
        Sesion nuevaSession = adminSesionService.createSesion(session);
        return new ResponseEntity<>(nuevaSession, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sesion> getSession(@PathVariable Long id) {
        Sesion session = adminSesionService.getSesionById(id);
        if (session != null) {
            return new ResponseEntity<>(session, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Sesion>> getAllSessions() {
        List<Sesion> sessions = adminSesionService.getAllSesions();
        return new ResponseEntity<>(sessions, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sesion> updateSession(@PathVariable Long id, @RequestBody Sesion session) {
        Sesion updatedSession = adminSesionService.updateSesion(id, session);
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
    public ResponseEntity<List<Sesion>> getSessionsByAdultoMayor(@PathVariable Long id) {
        List<Sesion> sessions = adminSesionService.getSesionsByAdultoMayor(id);
        return new ResponseEntity<>(sessions, HttpStatus.OK);
    }

    @GetMapping("/voluntario/{id}")
    public ResponseEntity<List<Sesion>> getSessionsByVoluntario(@PathVariable Long id) {
        List<Sesion> sessions = adminSesionService.getSesionsByVoluntario(id);
        return new ResponseEntity<>(sessions, HttpStatus.OK);
    }
}
