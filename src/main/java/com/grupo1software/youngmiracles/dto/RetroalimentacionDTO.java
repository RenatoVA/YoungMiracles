package com.grupo1software.youngmiracles.dto;

import com.grupo1software.youngmiracles.model.entity.AdultoMayor;
import com.grupo1software.youngmiracles.model.entity.Voluntario;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RetroalimentacionDTO {
    private Long id;
    @NotBlank(message= "El comentario es obligatorio")
    private String comentario;
    @NotBlank(message= "El puntaje es obligatorio")
    private Integer puntaje;
    @NotBlank(message= "El adultomayor es obligatorio")
    private AdultoMayor adultoMayor;
    @NotBlank(message= "El voluntario es obligatorio")
    private Voluntario voluntario;
}
