package com.grupo1software.youngmiracles.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.grupo1software.youngmiracles.model.entity.AdultoMayor;
import com.grupo1software.youngmiracles.model.entity.Voluntario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RetroalimentacionDTO {
    private Long id;
    @NotBlank(message= "El comentario es obligatorio")
    private String comentario;
    @NotNull(message= "El puntaje es obligatorio")
    private Integer puntaje;
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    @NotNull(message= "El adultomayor es obligatorio")
    private AdultoMayor adultoMayor;
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    @NotNull(message= "El voluntario es obligatorio")
    private Voluntario voluntario;
}
