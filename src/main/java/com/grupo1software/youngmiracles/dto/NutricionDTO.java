package com.grupo1software.youngmiracles.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NutricionDTO extends SesionDTO {
    private String indicaciones;
    private String receta;
}

