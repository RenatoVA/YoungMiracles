package com.grupo1software.youngmiracles.dto;

import com.grupo1software.youngmiracles.model.entity.AdultoMayor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FamiliarDTO extends UsuarioDTO{
    @NotBlank(message= "La relacion con adulto es necesaria")
    private String relacionConAdulto;
    @NotNull(message= "El id del adultoayor asociado es obligatorio")
    private AdultoMayor usuarioAsociado;

}
