package com.grupo1software.youngmiracles.dto;

import com.grupo1software.youngmiracles.model.entity.AdultoMayor;
import com.grupo1software.youngmiracles.model.entity.Progreso;
import com.grupo1software.youngmiracles.model.entity.Voluntario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReporteDTO {
    private Long id;
    @NotBlank(message= "El id del progreso es obligatorio")
    private Progreso progreso;
    @NotBlank(message= "La descripcion es obligatoria")
    private String descripcion;
    private LocalDateTime fecha;
    @NotNull(message= "El id del adulto mayor es obligatorio")
    private AdultoMayor adultoMayor;
    @NotNull(message= "El id del voluntario es obligatorio")
    private Voluntario voluntario;
}
