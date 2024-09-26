package com.grupo1software.youngmiracles.controller;

import com.grupo1software.youngmiracles.dto.MensajeDTO;
import com.grupo1software.youngmiracles.service.AdminMensajeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/mensajes")
public class AdminMensajeController {
    private final AdminMensajeService adminMensajeService;


    @PostMapping
    public ResponseEntity<MensajeDTO> createMensaje(@Valid @RequestBody MensajeDTO mensaje) {
        MensajeDTO nuevoMensaje = adminMensajeService.createMensaje(mensaje);
        return new ResponseEntity<>(nuevoMensaje, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MensajeDTO> getMensaje(@PathVariable Long id) {
        MensajeDTO mensaje = adminMensajeService.getMensajeByID(id);
        if (mensaje != null) {
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MensajeDTO> updateMensaje(@PathVariable Long id, @Valid @RequestBody MensajeDTO mensaje) {
        MensajeDTO updatedmensaje = adminMensajeService.updateMensaje(id, mensaje);
        if (updatedmensaje != null) {
            return new ResponseEntity<>(updatedmensaje, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMensaje(@PathVariable Long id) {
        adminMensajeService.deleteMensaje(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
