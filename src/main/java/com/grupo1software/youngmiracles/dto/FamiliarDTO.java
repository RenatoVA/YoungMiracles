package com.grupo1software.youngmiracles.dto;

import com.grupo1software.youngmiracles.model.entity.AdultoMayor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FamiliarDTO extends UsuarioDTO{
    private String relacionConAdulto;
    private AdultoMayor usuarioAsociado;

}
