package com.grupo1software.youngmiracles.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SesionResponseDTO {
    private Long id;
    private LocalDateTime fecha;
    private String estado;
    private Long adultomayorId;
    private Long voluntarioId;
    private Integer duracion;
}
