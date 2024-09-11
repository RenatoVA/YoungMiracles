package com.grupo1software.youngmiracles.model.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "sesiones")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tiposesion"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Fisioterapia.class, name = "fisioterapia"),
        @JsonSubTypes.Type(value = Taller.class, name = "taller"),
})
public class Sesion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaRegistro;
    private LocalDateTime fecha;
    private String estado;
    @ManyToOne
    @JoinColumn(name = "adulto_mayor_id", referencedColumnName = "id",foreignKey = @ForeignKey(name="FK_SESION_ADULTOMAYOR"))
    private AdultoMayor adultoMayor;
    @ManyToOne
    @JoinColumn(name = "voluntario_id",referencedColumnName = "id",foreignKey = @ForeignKey(name="FK_SESION_VOLUNTARIO"))
    private Voluntario voluntario;
    private Integer duracion;
}
