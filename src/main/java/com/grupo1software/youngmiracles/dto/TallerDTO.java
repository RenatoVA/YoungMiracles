package com.grupo1software.youngmiracles.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TallerDTO extends SesionCreateUpdateDTO {
    @NotBlank(message= "La descripcion es obligatoria")
    private String descripcion;
    @NotNull(message= "La capacidad maxima es obligatoria")
    private Integer capacidadMaxima;
    @NotBlank(message= "El material requerido es obligatorio")
    private String materialRequerido;
}
