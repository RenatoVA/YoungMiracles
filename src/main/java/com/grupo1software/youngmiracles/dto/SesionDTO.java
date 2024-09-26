package com.grupo1software.youngmiracles.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.grupo1software.youngmiracles.model.entity.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


import java.time.LocalDateTime;
@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tiposesion"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Fisioterapia.class, name = "fisioterapia"),
        @JsonSubTypes.Type(value = Taller.class, name = "taller"),
        @JsonSubTypes.Type(value = Nutricion.class, name = "nutricion"),

})
public class SesionDTO {

    private Long id;
    private LocalDateTime fechaRegistro;
    @NotNull(message= "La fecha es obligatorio es obligatorio")
    private LocalDateTime fecha;
    @NotBlank (message= "El estado es obligatorio")
    private String estado;
    @NotNull (message= "El id del adulto mayor es obligatorio")
    private AdultoMayor adultoMayor;
    @NotNull(message= "El id del voluntario es obligatorio")
    private Voluntario voluntario;
    @NotBlank (message= "El nombre es obligatorio")
    private Integer duracion;
}
