package com.grupo1software.youngmiracles.dto;

import lombok.Data;

@Data
public class TallerResponseDTO extends SesionResponseDTO{
    private String descripcion;
    private Integer capacidadMaxima;
    private String materialRequerido;
}
