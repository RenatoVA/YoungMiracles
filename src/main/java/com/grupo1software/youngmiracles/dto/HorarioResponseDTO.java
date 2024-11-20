package com.grupo1software.youngmiracles.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class HorarioResponseDTO {
    private Long id;
    private LocalDate fecha;
    private String hora_inicio;
    private String hora_fin;
    private Long voluntario_id;
    private String voluntario_nombre;
    private String voluntario_especialidad;
}
