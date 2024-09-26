package com.grupo1software.youngmiracles.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class VoluntarioDTO extends UsuarioDTO{
    @NotBlank(message= "La especialidad es obligatorio")
    private String especialidad;
    @NotNull(message= "Las horas disponibles son obligatorias")
    private Integer horasDisponibles;
    @NotNull (message= "La experiencia es obligatoria")
    private Integer experiencia;
}
