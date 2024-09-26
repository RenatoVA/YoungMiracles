package com.grupo1software.youngmiracles.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipousuario"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AdultoMayorDTO.class, name = "adultomayor"),
        @JsonSubTypes.Type(value = VoluntarioDTO.class, name = "voluntario"),
        @JsonSubTypes.Type(value = FamiliarDTO.class, name = "familiar")
})
public class UsuarioDTO {
    private Long id;
    @NotBlank (message= "El nombre es obligatorio")
    @Size (max=50,message="El nombre debe tener 50 caracteres o menos")
    private String nombre;
    @NotBlank (message= "El apellido paterno es obligatorio")
    @Size (max=50,message="El apellido paterno 50 caracteres o menos")
    private String apellido_paterno;
    @NotBlank (message= "El apellido materno es obligatorio")
    @Size (max=50,message="El apellido materno 50 caracteres o menos")
    private String apellido_materno;
    @NotBlank (message= "La edad es obligatorio")
    @Size (max=4,message="La edad tiene que ser menos de 4 digitos")
    private Integer edad;
    private String genero;
    private String correo;
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private LocalDateTime fechaRegistro;
}