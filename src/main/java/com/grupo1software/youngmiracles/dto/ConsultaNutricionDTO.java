package com.grupo1software.youngmiracles.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ConsultaNutricionDTO {
    private Long id;
    private LocalDate fechaConsulta;
    private String condicionSalud;
    private String recomendaciones;
    private Long adultoMayorId;
}
