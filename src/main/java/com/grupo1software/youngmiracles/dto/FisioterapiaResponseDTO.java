package com.grupo1software.youngmiracles.dto;

import lombok.Data;

@Data
public class FisioterapiaResponseDTO extends SesionResponseDTO{
    private String tipoFisioterapia;
    private String observaciones;
}
