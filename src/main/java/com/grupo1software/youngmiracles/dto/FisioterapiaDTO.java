package com.grupo1software.youngmiracles.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FisioterapiaDTO extends SesionCreateUpdateDTO {
    @NotBlank(message= "El tipo de fisioterapia es obligatoria")
    private String tipoFisioterapia;
    @NotBlank(message= "Las observaciones son obligatorias")
    private String observaciones;
}
