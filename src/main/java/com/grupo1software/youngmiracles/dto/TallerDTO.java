package com.grupo1software.youngmiracles.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TallerDTO extends SesionDTO{
    private String descripcion;
    private Integer capacidadMaxima;
    private String materialRequerido;
}
