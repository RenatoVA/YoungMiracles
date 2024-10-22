package com.grupo1software.youngmiracles.controller;

import com.grupo1software.youngmiracles.dto.FacturaCreateUpdateDTO;
import com.grupo1software.youngmiracles.dto.FacturaResponseDTO;
import com.grupo1software.youngmiracles.model.entity.Horario;
import com.grupo1software.youngmiracles.service.AdminFacturaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/facturas")
public class AdminFacturaController {

    private final AdminFacturaService adminFacturaService;

    @GetMapping("/{id}")
    public ResponseEntity<FacturaResponseDTO> getFactura(@PathVariable Long id) {
        FacturaResponseDTO factura = adminFacturaService.getFactura(id);
        if (factura != null) {
            return new ResponseEntity<>(factura, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<FacturaResponseDTO> createFactura(@Valid @RequestBody FacturaCreateUpdateDTO facturaCreateUpdateDTO){
        FacturaResponseDTO factura = adminFacturaService.createFactura(facturaCreateUpdateDTO);
        return new ResponseEntity<>(factura, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FacturaResponseDTO> deleteFactura(@PathVariable Long id){
        adminFacturaService.deleteFactura(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
