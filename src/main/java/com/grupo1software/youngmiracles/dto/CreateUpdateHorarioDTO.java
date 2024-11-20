package com.grupo1software.youngmiracles.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateUpdateHorarioDTO {
    @NotNull(message= "El dia es obligatorio")
    private LocalDate fecha;
    @NotBlank(message= "la hora de inicio es obligatorio")
    private String hora_inicio;
    @NotBlank(message= "la hora de fin es obligatorio")
    private String hora_fin;
    @NotNull(message= "el id del voluntario es obligatorio")
    private Long voluntario_id;

}
