package com.grupo1software.youngmiracles.controller;


import com.grupo1software.youngmiracles.model.entity.Recordatorio;
import com.grupo1software.youngmiracles.service.AdminRecordatorioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/recordatorios")
public class AdminRecordatorioController {
    private final AdminRecordatorioService adminRecordatorioService;

    @PostMapping
    public ResponseEntity<Recordatorio> createRecordatorio(@RequestBody Recordatorio recordatorio) {
        Recordatorio nuevoRecordatorio = adminRecordatorioService.createRecordatorio(recordatorio);
        return new ResponseEntity<>(nuevoRecordatorio, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recordatorio> getRecordatorio(@PathVariable Long id) {
        Recordatorio recordatorio = adminRecordatorioService.getRecordatorioById(id);
        if (recordatorio != null) {
            return new ResponseEntity<>(recordatorio, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Recordatorio>> getAllRecordatorios() {
        List<Recordatorio> recordatorios = adminRecordatorioService.getAllRecordatorios();
        return new ResponseEntity<>(recordatorios, HttpStatus.OK);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Recordatorio>> getRecordatoriosByUsuarioId(@PathVariable Long usuarioId) {
        List<Recordatorio> recordatorios = adminRecordatorioService.getRecordatoriosByUsuarioId(usuarioId);
        return new ResponseEntity<>(recordatorios, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recordatorio> updateRecordatorio(@PathVariable Long id, @RequestBody Recordatorio recordatorio) {
        Recordatorio updatedRecordatorio = adminRecordatorioService.updateRecordatorio(id, recordatorio);
        if (updatedRecordatorio != null) {
            return new ResponseEntity<>(updatedRecordatorio, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecordatorio(@PathVariable Long id) {
        adminRecordatorioService.deleteRecordatorio(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
