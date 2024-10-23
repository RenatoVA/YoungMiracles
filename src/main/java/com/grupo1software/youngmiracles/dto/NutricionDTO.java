package com.grupo1software.youngmiracles.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NutricionDTO extends SesionCreateUpdateDTO {
    @NotBlank(message= "Las indicaciones son obligatorias")
    private String indicaciones;
    @NotBlank(message= "La receta es obligatoria")
    private String receta;
}

