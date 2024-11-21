package com.grupo1software.youngmiracles.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReporteVoluntarioResponseDTO {
    private int totalSesiones;
    private int completadas;
    private int canceladas;
    private int pendientes;
    private int horasTrabajadas;
    private LocalDate ultimaSesion;
    private double tasaCancelacion;
}
