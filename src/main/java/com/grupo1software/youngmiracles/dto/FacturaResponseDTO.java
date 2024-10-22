package com.grupo1software.youngmiracles.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FacturaResponseDTO {
    private Long facturaId;
    private Long usuarioId;
    private Long voluntarioId;
    private LocalDateTime fecha;
    private Float total;
    private String servicio;
    private String estado;
}
