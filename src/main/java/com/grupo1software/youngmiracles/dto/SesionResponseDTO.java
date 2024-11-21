package com.grupo1software.youngmiracles.dto;

import com.grupo1software.youngmiracles.model.entity.Horario;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class SesionResponseDTO {
    private Long id;
    private LocalDate fecha;
    private String estado;
    private HorarioResponseDTO horario;
    private Long adultomayorId;
    private String adultomayorNombre;
    private Long voluntarioId;
    private String voluntarioNombre;
    private Integer duracion;
    private String tipoSesion;
}
