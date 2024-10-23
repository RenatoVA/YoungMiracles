package com.grupo1software.youngmiracles.dto;

import lombok.Data;

@Data
public class CapacitacionDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private String contenido;
    private Long voluntarioId;
}

