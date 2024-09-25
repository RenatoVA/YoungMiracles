package com.grupo1software.youngmiracles.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class VoluntarioDTO extends UsuarioDTO{
    private String especialidad;
    private Integer horasDisponibles;
    private Integer experiencia;
}
