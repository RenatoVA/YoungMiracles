package com.grupo1software.youngmiracles.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FisioterapiaDTO extends SesionDTO {
    private String tipoFisioterapia;
    private String observaciones;
}
