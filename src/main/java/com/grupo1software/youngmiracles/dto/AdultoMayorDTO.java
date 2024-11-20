package com.grupo1software.youngmiracles.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AdultoMayorDTO extends UsuarioDTO {
    @NotBlank(message= "El nivel de actividad es obligatoria")
    private String nivelActividad;
    @NotNull(message= "EL campo necesitaAsistenciaFamiliar es obligatorio")
    private Boolean necesitaAsistenciaFamiliar;
}
