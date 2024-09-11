package com.grupo1software.youngmiracles.model.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Data
@Entity
@Table(name = "usuarios")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipoUsuario"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AdultoMayor.class, name = "adultomayor"),
        @JsonSubTypes.Type(value = Voluntario.class, name = "voluntario"),
        @JsonSubTypes.Type(value = Familiar.class, name = "familiar")
})
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private Integer edad;
    private String genero;
    private String correo;
    private LocalDateTime fechaRegistro;
}