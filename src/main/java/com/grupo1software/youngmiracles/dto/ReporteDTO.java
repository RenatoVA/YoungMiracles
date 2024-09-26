package com.grupo1software.youngmiracles.dto;

import com.grupo1software.youngmiracles.model.entity.AdultoMayor;
import com.grupo1software.youngmiracles.model.entity.Progreso;
import com.grupo1software.youngmiracles.model.entity.Voluntario;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReporteDTO {
    private Long id;
    private Progreso progreso;
    private String descripcion;
    private LocalDateTime fecha;
    private AdultoMayor adultoMayor;
    private Voluntario voluntario;
}
