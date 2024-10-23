package com.grupo1software.youngmiracles.dto;

import lombok.Data;

@Data
public class NutricionResponseDTO extends SesionResponseDTO {
    private String indicaciones;
    private String receta;
}
