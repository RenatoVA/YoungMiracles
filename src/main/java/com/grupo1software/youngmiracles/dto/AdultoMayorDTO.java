package com.grupo1software.youngmiracles.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AdultoMayorDTO extends UsuarioDTO {
    private String condicionSalud;
    private String nivelActividad;
    private Boolean necesitaAsistenciaFamiliar;
}
