package com.grupo1software.youngmiracles.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.grupo1software.youngmiracles.model.entity.*;
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
    private LocalDateTime fecha;
    private String estado;
    private AdultoMayor adultoMayor;
    private Voluntario voluntario;
    private Integer duracion;
}
