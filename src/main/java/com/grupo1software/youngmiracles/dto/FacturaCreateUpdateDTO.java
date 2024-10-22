package com.grupo1software.youngmiracles.dto;

import lombok.Data;

@Data
public class FacturaCreateUpdateDTO {
    private Long usuarioId;
    private String servicio;
    private Long voluntarioId;
}
