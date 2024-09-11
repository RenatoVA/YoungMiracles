package com.grupo1software.youngmiracles.model.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "recordatorios")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tiporecordatorio"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = RecordatorioPastilla.class, name = "recordatoriopastilla"),
        @JsonSubTypes.Type(value = RecordatorioSesion.class, name = "recordatoriosesion"),
})

public class Recordatorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id",foreignKey = @ForeignKey(name="FK_RECORDATORIO_USUARIO"))
    private Usuario usuario;

    @Column(nullable = false)
    private String descripcion;
}
